/**
 * 
 */
package addressbook.vcardprocessor.visitors;

import addressbook.appbeans.ICardContext;
import addressbook.appbeans.vCardDataBean;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class NameAcceptor implements ICardAcceptor
{

	private final ICardContext context;
	
	/**
	 * @param context
	 */
	public NameAcceptor(ICardContext context)
	{
		this.context = context;
	}

	
	/**
	 * @return the rawCardData
	 */
	public ICardContext getRawCardData()
	{
		return context;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(ICardVisitor visitor)
	{
		visitor.atName(this);
	}

	/**
	 * @param dataBean
	 */
	public void visitForName(final vCardDataBean dataBean)
	{
		final String newLine = new String("\\r");
		final String[] tokens = context.getRawData().split(newLine);
		
		String firstName = "", lastname = "" , middlename = "";
		for (String token : tokens) 
		{
			if(token.startsWith("N"))
			{
				firstName = token.substring(token.indexOf(";")+1);
				lastname = token.substring(token.indexOf(":")+1,token.indexOf(";"));
				//XXX:: Fix the middle name criteria.
				//middlename = token.substring(token.indexOf(";")+1, token.lastIndexOf(";")-1);
				break;
			}
		}
		dataBean.setFirstName(firstName);
		dataBean.setLastName(lastname);
		dataBean.setMiddleName(middlename);
	}
}
