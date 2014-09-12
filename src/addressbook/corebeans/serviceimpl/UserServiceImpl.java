/**
 * 
 */
package addressbook.corebeans.serviceimpl;

import addressbook.corebeans.IUser;
import addressbook.corebeans.service.AbstractPersistanceService;
import addressbook.corebeans.service.IUserService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class UserServiceImpl extends AbstractPersistanceService<IUser> implements IUserService
{

	@Override
	public IUser createUser(String username, String password) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean commit(IUser entityToCommit)
	{
		return super.commit(entityToCommit);
	}

	@Override
	public void delete(IUser entityToDelete)
	{
		super.delete(entityToDelete);

	}

	@Override
	public IUser find(Object objToFind) 
	{
		// TODO this should be specific to the user.
		return super.find(objToFind);
	}

	@Override
	public IUser update(IUser objToUpdate)
	{
		return super.update(objToUpdate);
	}

	@Override
	public IUser getUserByName(String username)
	{
		
		return null;
	}

	

}
