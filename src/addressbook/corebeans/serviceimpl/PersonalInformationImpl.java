/**
 * 
 */
package addressbook.corebeans.serviceimpl;

import addressbook.applicationbeans.ICardContext;
import addressbook.corebeans.PersonalInformation;
import addressbook.corebeans.service.IPersonalInformationService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class PersonalInformationImpl extends AbstractPersistanceService<PersonalInformation> implements	IPersonalInformationService {

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IGenericDAO#commit(java.lang.Object)
	 */
	@Override
	public boolean commit(PersonalInformation entityToCommit)
	{
		return super.commit(entityToCommit);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IGenericDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(PersonalInformation entityToDelete)
	{
		super.delete(entityToDelete);

	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IGenericDAO#find(java.lang.Object)
	 */
	@Override
	public PersonalInformation find(Object objToFind)
	{
		return super.find(objToFind);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IGenericDAO#update(java.lang.Object)
	 */
	@Override
	public PersonalInformation update(PersonalInformation objToUpdate)
	{
		return super.update(objToUpdate);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IPersonalInformationService#createPersonalInformation(addressbook.applicationbeans.ICardContext)
	 */
	@Override
	public PersonalInformation createPersonalInformation(ICardContext context)
	{
		return null;
	}

}
