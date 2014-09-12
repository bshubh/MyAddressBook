/**
 * 
 */
package addressbook.vcardprocessor;

import addressbook.applicationbeans.CardContextImpl;
import addressbook.applicationbeans.ICardContext;

/**
 * This interface will define the contract for creating card processor.
 * 
 * At first, the version of the {@link CardContextImpl} will checked.
 * if a processor is in the chain then it will be forwarded to the corresponding processor.
 * Corresponding processor will be responsible for further processing the data from the {@link CardContextImpl}.
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
	void parseCardData(ICardContext context);
}
