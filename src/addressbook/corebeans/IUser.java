/**
 * 
 */
package addressbook.corebeans;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;


/**
 * Basic User of the Application.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public interface IUser extends IEntity
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
	 * @param userrole
	 * @return
	 */
	boolean hasUserRole(IUserRole userrole);
	
	/**
	 * @return
	 */
	Collection<IUserRole> getAssignedUserRoles();
	
	/**
	 * @return
	 */
	UUID getUserIdentifier();
	
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
	
	
}
