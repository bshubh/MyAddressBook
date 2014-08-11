/**
 * 
 */
package addressbook.visitors;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IVisitor
{
	void atBegining(BeginnerAcceptor acceptor);
	
	void atName(NameVisitable nameVisitable);
	
	void atOrganization(OrganizationVisitable orgVisitable);
	
	void atWorkTelephone(WorkTelephoneVisitable workTelVisitable);
	
	void atHomeTelephone(HomeTelephoneVisitable homeTelVisitable);
}
