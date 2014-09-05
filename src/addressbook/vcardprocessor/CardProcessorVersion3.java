/**
 * 
 */
package addressbook.vcardprocessor;

import addressbook.applicationbeans.CardContextImpl;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class CardProcessorVersion3 extends AbstractCardProcessor
{


	/**
	 * @param nextProcessor
	 */
	public CardProcessorVersion3(IvCardProcessor nextProcessor) 
	{
		super(nextProcessor);
	}



	/* (non-Javadoc)
	 * @see com.addressbook.vcardprocessor.IvCardProcessor#process(java.lang.String)
	 */
	@Override
	public void parseCardData(CardContextImpl data)
	{
		if(data.isVersion3())
		{
			// XXX :: deroute to the card data 3 processor.
		}
		else
		{
			if(getNextInChain() != null)
			{
				getNextInChain().parseCardData(data);
			}
		}

	}

}
