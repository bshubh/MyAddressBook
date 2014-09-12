/**
 * 
 */
package addressbook.vcardprocessor;

import addressbook.applicationbeans.ICardContext;
import addressbook.applicationbeans.vCardVersion;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class CardProcessorVersion4 implements IvCardProcessor
{

	private IvCardProcessor nextProcessor;


	@Override
	public void parseCardData(ICardContext context)
	{
		if(context.getVersion() == vCardVersion.v4_0)
		{
		}
		else
		{
			nextProcessor.parseCardData(context);
		}
		
	}

}
