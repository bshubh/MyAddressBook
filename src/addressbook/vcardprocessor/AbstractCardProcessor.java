/**
 * 
 */
package addressbook.vcardprocessor;

import java.util.LinkedList;
import java.util.List;

import addressbook.applicationbeans.CardContextImpl;

/**
 * @author Shubhashish Bhowmik
 *
 */
public abstract class AbstractCardProcessor implements IvCardProcessor
{

	private final IvCardProcessor nextInChain;
	private final List<IvCardProcessor> procssorChain = new LinkedList<IvCardProcessor>();
	
	/**
	 * @param nextInChain
	 */
	protected AbstractCardProcessor(IvCardProcessor nextInChain)
	{
		this.nextInChain = nextInChain;
	}

	
	/**
	 * @return the nextInChain
	 */
	public IvCardProcessor getNextInChain()
	{
		return nextInChain;
	}

	/* (non-Javadoc)
	 * @see addressbook.vcardprocessor.IvCardProcessor#parseCardData(addressbook.vcardprocessor.RawCardData)
	 */
	public abstract void parseCardData(CardContextImpl data); 

}
