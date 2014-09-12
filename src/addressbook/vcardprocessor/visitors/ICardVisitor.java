/**
 * 
 */
package addressbook.vcardprocessor.visitors;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface ICardVisitor
{
	void atStart(BeginnerAcceptor acceptor);
	
	void atName(NameAcceptor nameVisitable);
	
	void atOrganization(OrganizationAcceptor orgVisitable);
	
	void atWorkTelephone(WorkTelephoneAcceptor workTelVisitable);
	
	void atHomeTelephone(HomeTelephoneAcceptor homeTelVisitable);
	
	void atOrganizationAddress(OrganizationAddressAcceptor orgAddressVisitable);
	
	void atHomeAddress(HomeAddressAcceptor homeAddressVisitable);
	
	void atEmailAddress(EmailAddressAcceptor emailAddressVisitable);
	
	void atEnd(EndAcceptor endAcceptor);
}
