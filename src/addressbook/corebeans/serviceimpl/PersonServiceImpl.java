/**
 * 
 */
package addressbook.corebeans.serviceimpl;

import addressbook.applicationbeans.ICardContext;
import addressbook.applicationbeans.vCardDataBean;
import addressbook.corebeans.Person;
import addressbook.corebeans.service.IPersonService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class PersonServiceImpl extends AbstractPersistanceService<Person> implements IPersonService
{


	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#commit(java.lang.Object)
	 */
	@Override
	public boolean commit(Person entityToCommit)
	{
		return super.commit(entityToCommit);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(Person entityToDelete)
	{
		super.delete(entityToDelete);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#find(java.lang.Object)
	 */
	@Override
	public Person find(Object objToFind)
	{
		return super.find(objToFind);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#update(java.lang.Object)
	 */
	@Override
	public Person update(Person objToUpdate)
	{
		return super.update(objToUpdate);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IPersonService#createPerson(addressbook.applicationbeans.ICardContext)
	 */
	@Override
	public Person createPerson(ICardContext context)
	{
		final vCardDataBean dataBean = context.getDataBean();
		final Person person = new Person(dataBean.getFirstName(), dataBean.getMiddleName(), dataBean.getLastName());
		person.setNickName(dataBean.getNickName());
		person.setEmailAddressList("sbhowmik@abc.zzz", true);
		// XXX :: Add the email address over here.
		return person;
	}

}
