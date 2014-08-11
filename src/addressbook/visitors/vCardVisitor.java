/**
 * 
 */
package addressbook.visitors;

import addressbook.contextobject.vCardDataBean;

/**
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

	
	/**
	 * @return the dataBean
	 */
	public vCardDataBean getDataBean()
	{
		return dataBean;
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

	
}
