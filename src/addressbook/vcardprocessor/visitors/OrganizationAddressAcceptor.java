/**
 * 
 */
package addressbook.vcardprocessor.visitors;

import addressbook.applicationbeans.CardContextImpl;
import addressbook.applicationbeans.ICardContext;
import addressbook.applicationbeans.vCardDataBean;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class OrganizationAddressAcceptor implements ICardAcceptor
{
	
	private final ICardContext context;

	
	/**
	 * @param context
	 */
	public OrganizationAddressAcceptor(ICardContext context)
	{
		this.context = context;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(ICardVisitor visitor)
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
