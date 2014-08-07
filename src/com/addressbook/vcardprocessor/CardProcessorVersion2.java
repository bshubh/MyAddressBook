/**
 * 
 */
package com.addressbook.vcardprocessor;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class CardProcessorVersion2 implements IvCardProcessor
{

	private IvCardProcessor nextProcessor;
	
	

	/* (non-Javadoc)
	 * @see com.addressbook.vcardprocessor.IvCardProcessor#forwardToNextLevel(com.addressbook.vcardprocessor.IvCardProcessor)
	 */
	@Override
	public void forwardToNextLevel(IvCardProcessor nextInChain) 
	{
		this.nextProcessor = nextInChain;

	}

	/* (non-Javadoc)
	 * @see com.addressbook.vcardprocessor.IvCardProcessor#process(java.lang.String)
	 */
	@Override
	public void process(RawCardData data)
	{
		if(data.isVersion2())
		{
			// XXX :: deroute to the card data 2 processor.
		}
		else
		{
			nextProcessor.process(data);
		}

	}

}
