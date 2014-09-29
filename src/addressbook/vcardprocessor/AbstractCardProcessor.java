/**
 * 
 */
package addressbook.vcardprocessor;

import addressbook.appbeans.ICardContext;
import addressbook.vcardprocessor.visitors.BeginnerAcceptor;
import addressbook.vcardprocessor.visitors.EndAcceptor;
import addressbook.vcardprocessor.visitors.HomeAddressAcceptor;
import addressbook.vcardprocessor.visitors.HomeTelephoneAcceptor;
import addressbook.vcardprocessor.visitors.ICardAcceptor;
import addressbook.vcardprocessor.visitors.NameAcceptor;
import addressbook.vcardprocessor.visitors.OrganizationAddressAcceptor;
import addressbook.vcardprocessor.visitors.OrganizationAcceptor;
import addressbook.vcardprocessor.visitors.WorkTelephoneAcceptor;

/**
 * @author Shubhashish Bhowmik
 *
 */
public abstract class AbstractCardProcessor implements IvCardProcessor
{

	
	/** Next {@link IvCardProcessor} in chain.  */
	private final IvCardProcessor nextInChain;
	
	/**
	 * @param nextInChain
	 */
	protected AbstractCardProcessor(IvCardProcessor nextInChain)
	{
		this.nextInChain = nextInChain;
		
	}

	//XXX :: Make it a stage visitor.
	protected void initialise(ICardContext context)
	{
		//XXX :: Move all these visitors to the somewhere else.
		final ICardAcceptor beginCardAcceptor = new BeginnerAcceptor(context);
		final ICardAcceptor nameAcceptor = new NameAcceptor(context);
		final ICardAcceptor orgAcceptor = new OrganizationAcceptor(context);
		final ICardAcceptor workTeleAcceptor = new WorkTelephoneAcceptor(context);
		final ICardAcceptor homeTeleAcceptor = new HomeTelephoneAcceptor(context);
		final ICardAcceptor orgAddressAcceptor = new OrganizationAddressAcceptor(context);
		final ICardAcceptor homeAddressAcceptor = new HomeAddressAcceptor(context);
		final ICardAcceptor endCardAcceptor = new EndAcceptor(context);
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
	public abstract void parseCardData(ICardContext data); 

}
