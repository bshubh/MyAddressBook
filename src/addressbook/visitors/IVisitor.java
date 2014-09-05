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
	void atStart(BeginnerAcceptor acceptor);
	
	void atName(NameVisitable nameVisitable);
	
	void atOrganization(OrganizationVisitable orgVisitable);
	
	void atWorkTelephone(WorkTelephoneVisitable workTelVisitable);
	
	void atHomeTelephone(HomeTelephoneVisitable homeTelVisitable);
	
	void atOrganizationAddress(OrganizationAddressVisitable orgAddressVisitable);
	
	void atHomeAddress(HomeAddressVisitable homeAddressVisitable);
	
	void atEmailAddress(EmailAddressVisitable emailAddressVisitable);
	
	void atEnd(EndAcceptor endAcceptor);
}
