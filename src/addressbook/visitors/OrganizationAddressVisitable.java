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
public class OrganizationAddressVisitable implements IVisitable
{
	
	private final CardContextImpl context;

	
	/**
	 * @param context
	 */
	public OrganizationAddressVisitable(CardContextImpl context)
	{
		this.context = context;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor)
	{
		visitor.atOrganizationAddress(this);
	}

	public void visitForOrganizationalAddress( final vCardDataBean dataBean)
	{
		final String newLine = new String("\\r");
		final String[] tokens = context.getRawData().split(newLine);
		
		String workAddress = "";
		for (String token : tokens) 
		{
			if(token.startsWith("ADR;WORK"))
			{
				workAddress = token.substring(token.indexOf(":")+1);
				break;
			}
		}
		
		dataBean.setWorkAddress(workAddress);
	}
}
