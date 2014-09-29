/**
 * 
 */
package addressbook.vcardprocessor.visitors;

import addressbook.appbeans.ICardContext;
import addressbook.appbeans.vCardDataBean;

/**
 * TODO : Make the arrangement of the multiple telephone numbers.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class HomeTelephoneAcceptor implements ICardAcceptor
{
	private final ICardContext context;
	
	
	
	/**
	 * @param context
	 */
	public HomeTelephoneAcceptor(ICardContext context) 
	{
		this.context = context;
	}



	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(ICardVisitor visitor) 
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
