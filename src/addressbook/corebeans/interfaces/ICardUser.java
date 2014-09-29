/**
 * 
 */
package addressbook.corebeans.interfaces;

import java.util.Collection;
import java.util.Date;

import addressbook.corebeans.application.Person;
import addressbook.corebeans.application.PersonalInformation;
import addressbook.corebeans.security.UserRole;



/**
 * Basic User of the Application.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public interface ICardUser extends IEntity
{
	/**
	 * @return
	 */
	String getUserName();
	
	/**
	 * @param dateToSync
	 */
	void setLastSyncDate(Date dateToSync);
	
	/**
	 * @return
	 */
	Date getLastSyncDate();
	
	/**
	 * @param {@link IUserRole} to check
	 * @return <code>true</code> if exists otherwise <code>false</code>.
	 */
	boolean hasUserRole(IUserRole userrole);
	
	/**
	 * @param {@link IUserRole} to add
	 * @return <code>true</code> if added successfully otherwise <code>false</code>.
	 */
	boolean addUserRole(UserRole userrole);
	
	/**
	 * @return
	 */
	Collection<UserRole> getAssignedUserRoles();
	
	/**
	 * @param toRemove
	 * @return
	 */
	boolean removeUserRole(IUserRole toRemove);
	
	/**
	 * @return
	 */
	long getIdentifier();
	
	/**
	 * @return
	 */
	boolean isActive();
	
	/**
	 * @param active
	 */
	void setActive(boolean active);
	
	/**
	 * @return
	 */
	boolean isSystemAdministrator();
	
	/**
	 * @return
	 */
	boolean isApplicationUser();
	
	/**
	 * @return
	 */
	boolean isApplicationAdmin();
	
	/**
	 * @param isSystemAdministrator
	 */
	void setSystemAdministrator(boolean isSystemAdministrator);
	
	/**
	 * @param isApplicationUser
	 */
	void setApplicationUser(boolean isApplicationUser);
	
	/**
	 * @param isApplicationAdmin
	 */
	void setApplicationAdmin(boolean isApplicationAdmin);
	
	/**
	 * @param p as {@link Person}.
	 */
	void setPerson(Person p);
	
	/**
	 * @return {@link Person}.
	 */
	Person getPerson();
	
	/**
	 * @param {@link PersonalInformation} to add.
	 */
	void setPersonalInformation(PersonalInformation personalInfo);
	
	/**
	 * @return {@link PersonalInformation}.
	 */
	PersonalInformation getPersonalInformation();
	
}
