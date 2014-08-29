/**
 * 
 */
package addressbook.visitors;

import addressbook.contextobject.vCardDataBean;

/**
 * Main visitor for visiting all the entries..
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class vCardVisitor implements IVisitor
{

	private final vCardDataBean dataBean;

	/**
	 * Parameterize constructor.
	 * 
	 * @param rawCardData
	 */
	public vCardVisitor()
	{
		this.dataBean = new vCardDataBean();
	}


	@Override
	public void atBegining(BeginnerAcceptor acceptor)
	{
		acceptor.visitForVersion(dataBean);
	}


	@Override
	public void atName(NameVisitable nameVisitable) 
	{
		nameVisitable.visitForName(dataBean);
	}


	@Override
	public void atOrganization(OrganizationVisitable orgVisitable) 
	{
		orgVisitable.visitForOrganization(dataBean);
	}


	@Override
	public void atWorkTelephone(WorkTelephoneVisitable workTelVisitable)
	{
		workTelVisitable.visitForWorkTelephone(dataBean);
		
	}


	@Override
	public void atHomeTelephone(HomeTelephoneVisitable homeTelVisitable) 
	{
		homeTelVisitable.visitForHomeTelephone(dataBean);
		
	}


	@Override
	public void atOrganizationAddress(OrganizationAddressVisitable orgAddressVisitable) 
	{
		orgAddressVisitable.visitForOrganizationalAddress(dataBean);
		
	}


	@Override
	public void atHomeAddress(HomeAddressVisitable homeAddressVisitable)
	{
		homeAddressVisitable.visitForHomeAddress(dataBean);
		
	}


	@Override
	public void atEmailAddress(EmailAddressVisitable emailAddressVisitable)
	{
		emailAddressVisitable.visitForEmailAddress(dataBean);
		
	}


	@Override
	public void atEnd(EndAcceptor endAcceptor)
	{
		endAcceptor.visitEnd(dataBean);
		
	}

	
}
