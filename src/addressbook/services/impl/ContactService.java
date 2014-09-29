/**
 * 
 */
package addressbook.services.impl;

import addressbook.corebeans.application.Contact;
import addressbook.corebeans.application.Person;
import addressbook.services.IContactService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class ContactService implements IContactService
{


	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IContactService#createContact(addressbook.corebeans.Person)
	 */
	@Override
	public Contact createContact(Person person)
	{
		final Contact contact = new Contact(person);
		
		return contact;
	}

}
