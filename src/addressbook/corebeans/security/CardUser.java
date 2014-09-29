/**
 * 
 */
package addressbook.corebeans.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import addressbook.corebeans.application.Person;
import addressbook.corebeans.application.PersonalInformation;
import addressbook.corebeans.customdatatype.HashString;
import addressbook.corebeans.interfaces.ICardUser;
import addressbook.corebeans.interfaces.IUserRole;


/**
 * This is base {@link CardUser} class for all the application users in this project.
 * 
 * @author Shubhashish Bhowmik
 *
 */
@Entity
@Table(name = "CARDUser")
@NamedQueries( 	{ @NamedQuery(name = "user.findAll", query = "Select * from CardUser") ,
				 @NamedQuery( name = "user.findByUsername", query = "Select cu from CardUser as cu where cu.userName = ?1")} 
			)
public class CardUser implements ICardUser
{
	
   /** Eclipse generated serialVersionUID.*/
   private static final long serialVersionUID = 5661859567194863937L;
   
   
   @Column(name = "Username",unique = true)
   private /*final*/ String userName;
   
   @Id
   @Column(name ="User_Identifier", unique = true)
   private /*final*/ long identifier;
   
   @Column(name = "Password")
   private /*final*/ HashString password;
   
   @Column( name = "LastLoginDate")
   private Date lastLoginDate;
   
   @Column(name = "lastSyncDate")
   private Date lastSyncDate;
   
   @Column(name = "IsActive")
   private boolean isActive;
   
   @Column(name = "IsSystemAdmministrator")
   private boolean isSystemAdministrator;
   
   @Column(name = "IsApplicationUser")
   private boolean isApplicationUser;
   
   @Column(name = "IsApplicationAdmin")
   private boolean isApplicationAdmin;
   
   @OneToMany(cascade = CascadeType.ALL)
   private /*final*/ Collection<UserRole> assignedRoles = new HashSet<UserRole>();
   
   @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
   @JoinColumn(name = "Person_Identifier")
   private Person person;
   
   @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
   @JoinColumn(name = "PersonalInfo_identifier")
   private PersonalInformation personalInformation;
   
	/**
	 *  Constructor for unit test case.
	 */
	public CardUser()
	{

	}

	/**
	 * Parameterize constructor.
	 * 
	 * @param userName as {@link String}.
	 * @param password as {@link String}.
	 */
	public CardUser(String userName, String password)
	{
		this.userName = userName;
		this.password = new HashString(password);
		identifier = System.currentTimeMillis();
	}

	/**
	 * @return the lastLoginDate as {@link Date}
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
	public Collection<UserRole> getAssignedUserRoles()
	{
		if(assignedRoles.isEmpty())
		{
			throw new RuntimeException("No roles are been assigned to the user.");
		}
		return Collections.unmodifiableCollection(assignedRoles);
	}

	@Override
	public boolean addUserRole(UserRole userrole) 
	{
		boolean success = true;
		if(! hasUserRole(userrole))
		{
			assignedRoles.add(userrole);
		}
		
		return success;
	}
	
	@Override
	public long getIdentifier()
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
	
	/**
	 * @return the person
	 */
	public Person getPerson() 
	{
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person)
	{
		this.person = person;
	}

	@Override
	public void setPersonalInformation(PersonalInformation personalInfo)
	{
		this.personalInformation = personalInfo;
		
	}

	@Override
	public PersonalInformation getPersonalInformation()
	{
		return this.personalInformation;
	}

	@Override
	public boolean removeUserRole(IUserRole toRemove)
	{
		return assignedRoles.remove(toRemove);
	}
	
	//XXX ::: Change the tostring to the custom implementation
	@Override
	public String toString() 
	{
		return "UserImpl [userName=" + userName + ", identifier=" + identifier
				+ ", password=" + password + ", assignedRoles=" + assignedRoles
				+ ", person=" + person + ", lastLoginDate=" + lastLoginDate
				+ ", lastSyncDate=" + lastSyncDate + ", isActive=" + isActive
				+ ", isSystemAdministrator=" + isSystemAdministrator
				+ ", isApplicationUser=" + isApplicationUser
				+ ", isApplicationAdmin=" + isApplicationAdmin + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (identifier ^ (identifier >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof CardUser))
		{
			return false;
		}
		CardUser other = (CardUser) obj;
		if (identifier != other.identifier)
		{
			return false;
		}
		return true;
	}

	
	
}
