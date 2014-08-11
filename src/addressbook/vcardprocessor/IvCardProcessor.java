/**
 * 
 */
package addressbook.vcardprocessor;

import addressbook.contextobject.CardContextDataObject;

/**
 * This interface will define the contract for creating card processor.
 * 
 * At first, the version of the {@link CardContextDataObject} will checked.
 * if a processor is in the chain then it will be forwarded to the corresponding processor.
 * Corresponding processor will be responsible for further processing the data from the {@link CardContextDataObject}.
 * 
 * 
 * @author Shubhashish Bhowmik
 *
 */
public interface IvCardProcessor
{
	
	/**
	 * This method will be responsible for processing the data further. 
	 * 
	 * @param data
	 */
	void parseCardData(CardContextDataObject data);
}
