/**
 * 
 */
package addressbook.vcardprocessor;

import addressbook.visitors.IVisitable;
import addressbook.visitors.IVisitor;
import addressbook.visitors.vCardAcceptor;
import addressbook.visitors.vCardVisitor;

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
	public void process(final RawCardData data)
	{
		if(data.isVersion2())
		{
			final IVisitable cardAcceptor = new vCardAcceptor(data);
			final IVisitor vCardVisitor = new vCardVisitor();
			
			cardAcceptor.accept(vCardVisitor); 
			//vCardVisitor.visitForName(nameVisitable);
			
			System.out.println(((vCardVisitor)vCardVisitor).getDataBean());
			//vCardVisitor.visitForOrganization();
		}
		else
		{
			nextProcessor.process(data);
		}

	}

}
