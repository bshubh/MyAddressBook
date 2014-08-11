/**
 * 
 */
package addressbook.vcardprocessor;

import addressbook.contextobject.CardContextDataObject;
import addressbook.visitors.IVisitable;
import addressbook.visitors.IVisitor;
import addressbook.visitors.BeginnerAcceptor;
import addressbook.visitors.NameVisitable;
import addressbook.visitors.OrganizationVisitable;
import addressbook.visitors.WorkTelephoneVisitable;
import addressbook.visitors.vCardVisitor;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class CardProcessorVersion2 extends  AbstractCardProcessor
{

	
	/**
	 * Parameterize constructor.
	 * Hence it will set the next processor in chain. 
	 * 
	 * @param {@link IvCardProcessor}.
	 */
	public CardProcessorVersion2(IvCardProcessor nextInChain)
	{
		super(nextInChain);
	}

	/* (non-Javadoc)
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
	public void parseCardData(final CardContextDataObject context)
	{
		if(context.isVersion2())
		{
			final IVisitable cardAcceptor = new BeginnerAcceptor(context);
			final IVisitable nameAcceptor = new NameVisitable(context);
			final IVisitable orgAcceptor = new OrganizationVisitable(context);
			final IVisitable workTeleAccpetor = new WorkTelephoneVisitable(context);
			final IVisitor vCardVisitor = new vCardVisitor();
			
			cardAcceptor.accept(vCardVisitor); 
			nameAcceptor.accept(vCardVisitor);
			orgAcceptor.accept(vCardVisitor);
			workTeleAccpetor.accept(vCardVisitor);
			
			
			System.out.println(((vCardVisitor)vCardVisitor).getDataBean());
		}
		else
		{
			if(getNextInChain() != null)
			{
				getNextInChain().parseCardData(context);
			}
		}

	}

}
