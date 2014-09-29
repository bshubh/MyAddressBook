/**
 * 
 */
package addressbook.vcardprocessor.visitors;

import addressbook.appbeans.ICardContext;
import addressbook.appbeans.vCardDataBean;

/**
 * Main visitor for visiting all the entries..
 * 
 * @author Shubhashish Bhowmik
 *
 */
public final class vCardVisitor implements ICardVisitor
{

	private final ICardContext cardContext;

	/**
	 * Parameterize constructor.
	 * 
	 * @param rawCardData
	 */
	public vCardVisitor(ICardContext cardContext)
	{
		this.cardContext = cardContext;
	}


	@Override
	public void atStart(BeginnerAcceptor acceptor)
	{
		acceptor.visitForVersion(cardContext.getDataBean());
	}


	@Override
	public void atName(NameAcceptor nameVisitable) 
	{
		nameVisitable.visitForName(cardContext.getDataBean());
	}


	@Override
	public void atOrganization(OrganizationAcceptor orgVisitable) 
	{
		orgVisitable.visitForOrganization(cardContext.getDataBean());
	}


	@Override
	public void atWorkTelephone(WorkTelephoneAcceptor workTelVisitable)
	{
		workTelVisitable.visitForWorkTelephone(cardContext.getDataBean());
		
	}


	@Override
	public void atHomeTelephone(HomeTelephoneAcceptor homeTelVisitable) 
	{
		homeTelVisitable.visitForHomeTelephone(cardContext.getDataBean());
		
	}


	@Override
	public void atOrganizationAddress(OrganizationAddressAcceptor orgAddressVisitable) 
	{
		orgAddressVisitable.visitForOrganizationalAddress(cardContext.getDataBean());
		
	}


	@Override
	public void atHomeAddress(HomeAddressAcceptor homeAddressVisitable)
	{
		homeAddressVisitable.visitForHomeAddress(cardContext.getDataBean());
		
	}


	@Override
	public void atEmailAddress(EmailAddressAcceptor emailAddressVisitable)
	{
		emailAddressVisitable.visitForEmailAddress(cardContext.getDataBean());
		
	}


	@Override
	public void atEnd(EndAcceptor endAcceptor)
	{
		endAcceptor.visitEnd(cardContext.getDataBean());
		
	}

	
}
