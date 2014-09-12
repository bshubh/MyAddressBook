/**
 * 
 */
package addressbook.vcardprocessor;

import addressbook.applicationbeans.ICardContext;
import addressbook.applicationbeans.vCardVersion;
import addressbook.vcardprocessor.visitors.BeginnerAcceptor;
import addressbook.vcardprocessor.visitors.EndAcceptor;
import addressbook.vcardprocessor.visitors.HomeAddressAcceptor;
import addressbook.vcardprocessor.visitors.HomeTelephoneAcceptor;
import addressbook.vcardprocessor.visitors.ICardAcceptor;
import addressbook.vcardprocessor.visitors.ICardVisitor;
import addressbook.vcardprocessor.visitors.NameAcceptor;
import addressbook.vcardprocessor.visitors.OrganizationAddressAcceptor;
import addressbook.vcardprocessor.visitors.OrganizationAcceptor;
import addressbook.vcardprocessor.visitors.WorkTelephoneAcceptor;
import addressbook.vcardprocessor.visitors.vCardVisitor;

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
	 * @see com.addressbook.vcardprocessor.IvCardProcessor#process(java.lang.String)
	 */
	@Override
	public void parseCardData(final ICardContext context)
	{
		//XXX :: Change this to switch statement
		if(context.getVersion() == vCardVersion.v2_1)
		{
			//XXX :: Move all these visitors to the somewhere else.
			final ICardAcceptor beginCardAcceptor = new BeginnerAcceptor(context);
			
			//XXX:: Remove them , as this has been transferred to the Beginner Acceptor class.
			/*final ICardAcceptor nameAcceptor = new NameAcceptor(context);
			final ICardAcceptor orgAcceptor = new OrganizationAcceptor(context);
			final ICardAcceptor workTeleAcceptor = new WorkTelephoneAcceptor(context);
			final ICardAcceptor homeTeleAcceptor = new HomeTelephoneAcceptor(context);
			final ICardAcceptor orgAddressAcceptor = new OrganizationAddressAcceptor(context);
			final ICardAcceptor homeAddressAcceptor = new HomeAddressAcceptor(context);
			final ICardAcceptor endCardAcceptor = new EndAcceptor(context);*/
			
			final ICardVisitor vCardVisitor = new vCardVisitor(context);
			
			beginCardAcceptor.accept(vCardVisitor); 
			/*nameAcceptor.accept(vCardVisitor);
			orgAcceptor.accept(vCardVisitor);
			workTeleAcceptor.accept(vCardVisitor);
			homeTeleAcceptor.accept(vCardVisitor);
			orgAddressAcceptor.accept(vCardVisitor);
			homeAddressAcceptor.accept(vCardVisitor);
			endCardAcceptor.accept(vCardVisitor);*/
			
			
			System.out.println(context.getDataBean());
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
