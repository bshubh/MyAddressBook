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
public class OrganizationVisitable implements IVisitable 
{

	private final CardContextImpl context;
	
	/** 
	 * Parameterize constructor.
	 * 
	 * @param context
	 */
	public OrganizationVisitable(CardContextImpl context)
	{
		this.context = context;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor) 
	{
		visitor.atOrganization(this);
	}

	/**
	 * @param dataBean
	 */
	public void visitForOrganization( final vCardDataBean dataBean)
	{
		final String newLine = new String("\\r");
		final String[] tokens = context.getRawData().split(newLine);
		
		String orgName = "", title = "" ;
		for (String token : tokens) 
		{
			if(token.startsWith("ORG"))
			{
				orgName = token.substring(token.indexOf(":")+1);
			}
			if(token.startsWith("TITLE"))
			{
				title = token.substring(token.indexOf(":")+1);
			}
		}
		
		dataBean.setOrganizationName(orgName);
		dataBean.setTitle(title);
	}
}
