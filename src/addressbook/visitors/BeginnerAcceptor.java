/**
 * 
 */
package addressbook.visitors;

import addressbook.contextobject.CardContextDataObject;
import addressbook.contextobject.vCardDataBean;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class BeginnerAcceptor implements IVisitable
{
	private final CardContextDataObject rawCardData;
	
	/**
	 * @param nameVisitable
	 * @param orgVisitable
	 */
	public BeginnerAcceptor(final CardContextDataObject rawCardData)
	{
		this.rawCardData = rawCardData;
	}
	

	/**
	 * @return the rawCardData
	 */
	public CardContextDataObject getRawCardData()
	{
		return rawCardData;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor)
	{
		visitor.atBegining(this);
	}

	/**
	 * @param dataBean
	 */
	public void visitForVersion(final vCardDataBean dataBean)
	{
		dataBean.setStartvCard(true);
		if (rawCardData.isVersion2())
		{
			dataBean.setVersion("2.1");
		}
		else if (rawCardData.isVersion3())
		{
			dataBean.setVersion("3.0");
		}
		else if (rawCardData.isVersion4())
		{
			dataBean.setVersion("4.0");
		}
	}
}
