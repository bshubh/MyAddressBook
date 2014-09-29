/**
 * 
 */
package addressbook.corebeans.persistence;

import java.util.Collection;
import java.util.List;

import addressbook.corebeans.interfaces.ICardUser;
import addressbook.corebeans.security.CardUser;

/**
 * DAO related to the user and its implementation.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class AppSecurityDAO extends AbstractPersistanceService<CardUser> implements IAppSecurityDAO
{

	/**
	 * Default Constructor.
	 * 
	 */
	public AppSecurityDAO()
	{
		
	}

	@Override
	public boolean checkAppAdmin()
	{
		boolean adminExists =true;
		final Collection<CardUser> adminUsers = findByNamedQueryAndParams("user.findByUsername", "CardAdmin");
		if(adminUsers.isEmpty() )
		{
			adminExists = false;
		}
		
		return adminExists;
	}

	@Override
	public ICardUser getAdminUser()
	{
		 Collection<CardUser> allUsers = this.findByNamedQueryAndParams("user.findByUsername","CardAdmin");
		 if(allUsers.isEmpty())
		 {
			 throw new RuntimeException("Unable to find the admin user");
		 }
		 else
		 {
			 return (ICardUser) ((List<CardUser>)allUsers).get(0);
		 }
	}


	public CardUser findByCriteria(String Query)
	{
		return null;
	}

}
