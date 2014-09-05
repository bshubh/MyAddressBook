/**
 * 
 */
package addressbook.visitors;

import addressbook.applicationbeans.CardContextImpl;
import addressbook.applicationbeans.vCardDataBean;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class HomeAddressVisitable implements IVisitable
{
	private final CardContextImpl context;
	
	
	/**
	 * @param context
	 */
	public HomeAddressVisitable(CardContextImpl context) 
	{
		this.context = context;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor)
	{
		visitor.atHomeAddress(this);

	}


	public void visitForHomeAddress(final vCardDataBean dataBean) 
	{
		final String newLine = new String("\\r");
		final String[] tokens = context.getRawData().split(newLine);
		
		String homeAddress = "";
		for (String token : tokens) 
		{
			if(token.startsWith("ADR;HOME"))
			{
				homeAddress = token.substring(token.indexOf(":")+1);
				break;
			}
		}
		
		dataBean.setHomeAddress(homeAddress);
	}

}
