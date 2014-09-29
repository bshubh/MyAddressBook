/**
 * 
 */
package addressbook.vcardprocessor.visitors;

import addressbook.appbeans.CardContextImpl;
import addressbook.appbeans.vCardDataBean;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class EmailAddressAcceptor implements ICardAcceptor 
{

	private final CardContextImpl context;
	
	
	/**
	 * @param context
	 */
	public EmailAddressAcceptor(CardContextImpl context) 
	{
		this.context = context;
	}


	@Override
	public void accept(ICardVisitor visitor)
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
