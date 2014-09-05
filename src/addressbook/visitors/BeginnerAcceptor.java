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
public class BeginnerAcceptor implements IVisitable
{
	private final CardContextImpl rawCardData;
	
	/**
	 * @param nameVisitable
	 * @param orgVisitable
	 */
	public BeginnerAcceptor(final CardContextImpl rawCardData)
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
		visitor.atStart(this);
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
