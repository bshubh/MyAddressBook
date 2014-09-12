/**
 * 
 */
package addressbook.corebeans;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

import addressbook.corebeans.customdatatype.HashString;


/**
 * @author Shubhashish Bhowmik
 *
 */
public class UserImpl implements IUser
{
	
   /** Eclipse generated serialVersionUID.*/
   private static final long serialVersionUID = 5661859567194863937L;
   
   
   private final String userName;
   private final UUID identifier;
   private final HashString password;
   private final Collection<IUserRole> assignedRoles = new HashSet<IUserRole>();
   
   private Date lastLoginDate;
   private Date lastSyncDate;
   private boolean isActive;
   private boolean isSystemAdministrator;
   private boolean isApplicationUser;
   private boolean isApplicationAdmin;
   
 

	/**
	 * @param userName
	 * @param password
	 */
	public UserImpl(String userName, String password)
	{
		this.userName = userName;
		this.password = new HashString(password);
		identifier = UUID.fromString(userName);
	}

	/**
	 * @return the lastLoginDate
	 */
	public Date getLastLoginDate() 
	{
		return lastLoginDate;
	}

	/**
	 * @param lastLoginDate the lastLoginDate to set
	 */
	public void setLastLoginDate(Date lastLoginDate) 
	{
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * @return the lastSyncDate
	 */
	public Date getLastSyncDate()
	{
		return lastSyncDate;
	}

	/**
	 * @param lastSyncDate the lastSyncDate to set
	 */
	public void setLastSyncDate(Date lastSyncDate)
	{
		this.lastSyncDate = lastSyncDate;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() 
	{
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	/**
	 * @return the identifier
	 */
	public UUID getIdentifier()
	{
		return identifier;
	}

	@Override
	public boolean hasUserRole(IUserRole userrole)
	{
		boolean success = false;
		if(! assignedRoles.isEmpty())
		{
			success = assignedRoles.contains(userrole);
		}
		return success;
	}

	@Override
	public Collection<IUserRole> getAssignedUserRoles()
	{
		if(assignedRoles.isEmpty())
		{
			throw new RuntimeException("No roles are been assigned to the user.");
		}
		return Collections.unmodifiableCollection(assignedRoles);
	}

	@Override
	public UUID getUserIdentifier()
	{
		return identifier;
	}

	/**
	 * @return the isSystemAdministrator
	 */
	public boolean isSystemAdministrator()
	{
		return isSystemAdministrator;
	}

	/**
	 * @param isSystemAdministrator the isSystemAdministrator to set
	 */
	public void setSystemAdministrator(boolean isSystemAdministrator)
	{
		this.isSystemAdministrator = isSystemAdministrator;
	}

	/**
	 * @return the isApplicationUser
	 */
	public boolean isApplicationUser() 
	{
		return isApplicationUser;
	}

	/**
	 * @param isApplicationUser the isApplicationUser to set
	 */
	public void setApplicationUser(boolean isApplicationUser)
	{
		this.isApplicationUser = isApplicationUser;
	}

	/**
	 * @return the isApplicationAdmin
	 */
	public boolean isApplicationAdmin() 
	{
		return isApplicationAdmin;
	}

	/**
	 * @param isApplicationAdmin the isApplicationAdmin to set
	 */
	public void setApplicationAdmin(boolean isApplicationAdmin)
	{
		this.isApplicationAdmin = isApplicationAdmin;
	}

	/**
	 * @return the userName
	 */
	public String getUserName()
	{
		return userName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "UserImpl [userName=" + userName + ", lastLoginDate="
				+ lastLoginDate + ", lastSyncDate=" + lastSyncDate
				+ ", isActive=" + isActive + ", isSystemAdministrator="
				+ isSystemAdministrator + ", isApplicationUser="
				+ isApplicationUser + ", isApplicationAdmin="
				+ isApplicationAdmin + "]";
	}

	
}
