/**
 * 
 */
package addressbook.vcardprocessor;

import addressbook.contextobject.CardContextDataObject;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class CardProcessorVersion4 implements IvCardProcessor
{

	private IvCardProcessor nextProcessor;
	
	
/*
	 (non-Javadoc)
	 * @see com.addressbook.vcardprocessor.IvCardProcessor#forwardToNextLevel(com.addressbook.vcardprocessor.IvCardProcessor)
	 
	@Override
	public void nextVersionProcessor(IvCardProcessor nextInChain) 
	{
		this.nextProcessor = nextInChain;

	}*/

	/* (non-Javadoc)
	 * @see com.addressbook.vcardprocessor.IvCardProcessor#process(java.lang.String)
	 */
	@Override
	public void parseCardData(CardContextDataObject data)
	{
		if(data.isVersion4())
		{
			// XXX :: deroute to the card data 3 processor.
		}
		else
		{
			nextProcessor.parseCardData(data);
		}

	}

}
