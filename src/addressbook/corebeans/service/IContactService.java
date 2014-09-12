/**
 * 
 */
package addressbook.corebeans.service;

import addressbook.corebeans.Contact;
import addressbook.corebeans.Person;

/**
 * Service interface with DAO capability.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public interface IContactService extends IPersistanceService<Contact>
{
	Contact createContact(Person person);
}
