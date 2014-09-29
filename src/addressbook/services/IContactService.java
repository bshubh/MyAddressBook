/**
 * 
 */
package addressbook.services;

import addressbook.corebeans.application.Contact;
import addressbook.corebeans.application.Person;

/**
 * Service interface with DAO capability.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public interface IContactService
{
	Contact createContact(Person person);
}
