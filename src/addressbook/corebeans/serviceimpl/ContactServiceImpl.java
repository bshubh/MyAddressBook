/**
 * 
 */
package addressbook.corebeans.serviceimpl;

import addressbook.corebeans.Contact;
import addressbook.corebeans.Person;
import addressbook.corebeans.service.AbstractPersistanceService;
import addressbook.corebeans.service.IContactService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class ContactServiceImpl extends AbstractPersistanceService<Contact> implements IContactService
{

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#commit(java.lang.Object)
	 */
	@Override
	public boolean commit(Contact entityToCommit) 
	{
		return super.commit(entityToCommit);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(Contact entityToDelete) 
	{
		super.delete(entityToDelete);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#find(java.lang.Object)
	 */
	@Override
	public Contact find(Object objToFind)
	{
		return super.find(objToFind);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#update(java.lang.Object)
	 */
	@Override
	public Contact update(Contact objToUpdate)
	{
		return super.update(objToUpdate);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IContactService#createContact(addressbook.corebeans.Person)
	 */
	@Override
	public Contact createContact(Person person)
	{
		Contact contact = new Contact(person);
		
		return contact;
	}

}
