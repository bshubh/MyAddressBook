/**
 * 
 */
package addressbook.visitors;

import addressbook.vcardprocessor.RawCardData;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class vCardAcceptor implements IVisitable
{
	private final RawCardData rawCardData;
	
	/**
	 * @param nameVisitable
	 * @param orgVisitable
	 */
	public vCardAcceptor(final RawCardData rawCardData)
	{
		this.rawCardData = rawCardData;
	}


	

	/**
	 * @return the rawCardData
	 */
	public RawCardData getRawCardData()
	{
		return rawCardData;
	}




	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor)
	{
		visitor.visit(this);
	}

}
