/**
 * 
 */
package com.addressbook.vcardprocessor;

/**
 * This interface will define the contract for creating card processor.
 * 
 * At first, the version of the {@link RawCardData} will checked.
 * if a processor is in the chain then it will be forwarded to the corresponding processor.
 * Corresponding processor will be responsible for further processing the data from the {@link RawCardData}.
 * 
 * 
 * @author Shubhashish Bhowmik
 *
 */
public interface IvCardProcessor
{
	/**
	 * This method will forward the call to the next in chain processor.
	 * @param nextInChain
	 */
	void forwardToNextLevel(IvCardProcessor nextInChain);
	
	
	/**
	 * This method will be responsible for processing the data further. 
	 * 
	 * @param data
	 */
	void process(RawCardData data);
}
