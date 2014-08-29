/**
 * 
 */
package addressbook.visitors;

import addressbook.contextobject.CardContextDataObject;
import addressbook.contextobject.vCardDataBean;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class EmailAddressVisitable implements IVisitable 
{

	private final CardContextDataObject context;
	
	
	/**
	 * @param context
	 */
	public EmailAddressVisitable(CardContextDataObject context) 
	{
		this.context = context;
	}


	@Override
	public void accept(IVisitor visitor)
	{
		visitor.atEmailAddress(this);
	}

	public void visitForEmailAddress(final vCardDataBean dataBean)
	{
		final String newLine = new String("\\r");
		final String[] tokens = context.getRawData().split(newLine);
		
		String emailAddress = "";
		for (String token : tokens) 
		{
			if(token.startsWith("EMAIL;PREF;INTERNET"))
			{
				emailAddress = token.substring(token.indexOf(":")+1);
				break;
			}
		}
		
		dataBean.setHomeTelephoneNr(emailAddress);
	}
}
