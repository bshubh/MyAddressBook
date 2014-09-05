/**
 * 
 */
package addressbook.visitors;

import addressbook.applicationbeans.CardContextImpl;
import addressbook.applicationbeans.vCardDataBean;

/**
 * TODO : Make the arrangement of the multiple telephone numbers.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class HomeTelephoneVisitable implements IVisitable
{
	private final CardContextImpl context;
	
	
	
	/**
	 * @param context
	 */
	public HomeTelephoneVisitable(CardContextImpl context) 
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
		
		String telHome = "";
		for (String token : tokens) 
		{
			if(token.startsWith("TEL;HOME;VOICE"))
			{
				telHome = token.substring(token.indexOf(":")+1);
				break;
			}
		}
		
		dataBean.setHomeTelephoneNr(telHome);
	}

}
