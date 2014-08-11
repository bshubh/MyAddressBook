/**
 * 
 */
package addressbook.visitors;

import addressbook.contextobject.CardContextDataObject;
import addressbook.contextobject.vCardDataBean;

/**
 * TODO : Make the arrangement of the multiple telephone numbers.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class HomeTelephoneVisitable implements IVisitable
{
	private final CardContextDataObject context;
	
	
	
	/**
	 * @param context
	 */
	public HomeTelephoneVisitable(CardContextDataObject context) 
	{
		this.context = context;
	}



	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor) 
	{
		visitor.atHomeTelephone(this);

	}


	/**
	 * @param {@link vCardDataBean}
	 */
	public void visitForHomeTelephone(vCardDataBean dataBean)
	{
		final String newLine = new String("\\r");
		final String[] tokens = context.getRawData().split(newLine);
		
		String telHome = "", lastname = "" , middlename = "";
		for (String token : tokens) 
		{
			if(token.startsWith("TEL;HOME"))
			{
				telHome = token.substring(token.indexOf(":")+1);
				break;
			}
		}
		
		dataBean.setHomeTelephoneNr(telHome);
	}

}
