/**
 * 
 */
package addressbook.services.impl;

import addressbook.corebeans.application.Person;
import addressbook.corebeans.application.PersonalInformation;
import addressbook.corebeans.application.PersonalInformation.Gender;
import addressbook.corebeans.interfaces.ICardUser;
import addressbook.corebeans.interfaces.IUserRole;
import addressbook.corebeans.persistence.AppSecurityDAO;
import addressbook.corebeans.persistence.IAppSecurityDAO;
import addressbook.corebeans.security.CardUser;
import addressbook.corebeans.security.DefaultApplicationUserRoles;
import addressbook.corebeans.security.UserRole;
import addressbook.services.IUserService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class CardUserService implements IUserService
{
	private final IAppSecurityDAO userDAO;

	/**
	 * @param userDAO
	 */
	public CardUserService(IAppSecurityDAO userDAO)
	{
		this.userDAO = new AppSecurityDAO();
	}

	@Override
	public ICardUser createAppUser(String username, String password) 
	{
		final ICardUser appUser = new CardUser(username, password);
		final UserRole userRole = new UserRole(DefaultApplicationUserRoles.USER.getRoleName(), DefaultApplicationUserRoles.USER.getRoleDescription());
		appUser.addUserRole(userRole);
		this.userDAO.commit((CardUser)appUser);
		return appUser;
	}
	
	
	@Override
	public ICardUser getUserByName(String username)
	{
		
		return null;
	}

	@Override
	public boolean addPersonalInformation(ICardUser user, PersonalInformation personInfo)
	{
		user.setPersonalInformation(personInfo);
		return this.userDAO.commit((CardUser)user);
	}

	@Override
	public boolean setPerson(ICardUser user, Person person)
	{
		user.setPerson(person);
		return this.userDAO.commit((CardUser)user);
	}

	@Override
	public boolean addUserRole(ICardUser user, UserRole toAdd)
	{
		user.addUserRole(toAdd);
		return this.userDAO.commit((CardUser)user);
	}

	@Override
	public boolean removeUserRole(ICardUser user, IUserRole toRemove)
	{
		boolean success = true;
		if(! user.hasUserRole(toRemove))
		{
			throw new RuntimeException("Following userrole :"+ toRemove +" doesn't exists for the user :"+ user.getUserName());
		}
		else
		{
			success = user.removeUserRole(toRemove);
		}
		return success;
	}

	@Override
	public ICardUser createAppAdmin()
	{
		ICardUser adminUser = null;
		
		if(! this.userDAO.checkAppAdmin())
		{
			adminUser = new CardUser("CardAdmin", "admin");
			final UserRole adminUserRole = new UserRole(DefaultApplicationUserRoles.ADMINISTRATOR.getRoleName(), DefaultApplicationUserRoles.ADMINISTRATOR.getRoleDescription());
			adminUser.addUserRole(adminUserRole );
			adminUser.setApplicationAdmin(true);
			final Person person = new Person("Admin", "", "Admin");
			adminUser.setPerson(person);
			final PersonalInformation info = new PersonalInformation();
			info.setGender(Gender.MALE);
			adminUser.setPersonalInformation(info);
			this.userDAO.commit((CardUser)adminUser);
		}
		else
		{
			adminUser = this.userDAO.getAdminUser();
		}
		
		return adminUser;
		
	}


	

}
