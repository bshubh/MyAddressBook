/**
 * 
 */
package addressbook.corebeans.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import addressbook.corebeans.interfaces.IUserRole;

/**
 * This will represents the role inside an application.
 * 
 * @author Shubhashish Bhowmik
 *
 */
@Entity
@Table(name = "UserRoles")
public class UserRole implements IUserRole
{

	/** Eclipse generated serialVersionUID.*/
	private static final long serialVersionUID = 5493623969117612118L;

	@Id
	@Column(name = "Role_Identifier")
	private long identifier;
	
	@Column(name = "RoleName" , nullable = false)
	private String roleName;
	
	@Column(name = "Description")
	private String roleDescription;

	
	/**
	 * @param roleName
	 * @param roleDescription
	 */
	public UserRole(String roleName, String roleDescription)
	{
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.identifier = System.currentTimeMillis();
	}

	/**
	 * @return the identifier
	 */
	public long getIdentifier()
	{
		return identifier;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() 
	{
		return roleName;
	}

	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() 
	{
		return roleDescription;
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
		if (!(obj instanceof UserRole))
		{
			return false;
		}
		UserRole other = (UserRole) obj;
		if (identifier != other.identifier)
		{
			return false;
		}
		return true;
	}

	
	
	
	
}
