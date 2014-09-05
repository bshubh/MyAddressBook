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
public class NameVisitable implements IVisitable
{

	private final CardContextImpl rawCardData;
	
	/**
	 * @param rawCardData
	 */
	public NameVisitable(CardContextImpl rawCardData)
	{
		this.rawCardData = rawCardData;
	}

	
	/**
	 * @return the rawCardData
	 */
	public CardContextImpl getRawCardData()
	{
		return rawCardData;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor)
	{
		visitor.atName(this);
	}

	/**
	 * @param dataBean
	 */
	public void visitForName(final vCardDataBean dataBean)
	{
		final String newLine = new String("\\r");
		final String[] tokens = rawCardData.getRawData().split(newLine);
		
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
