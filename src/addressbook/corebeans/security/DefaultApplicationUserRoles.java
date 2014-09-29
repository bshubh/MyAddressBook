/**
 * 
 */
package addressbook.corebeans.security;

/**
 * This <code>enum</code> will show the default application user roles.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public enum DefaultApplicationUserRoles
{
	/** Default Administrator of the application. */
	ADMINISTRATOR
	{
		public String getRoleName()
		{
			return "AppAdmin";
		}
		
		public String getRoleDescription()
		{
			return "Default application adminstration.";
		}
		
	},
	
	/** Default user of the application.*/
	USER
	{
		public String getRoleName()
		{
			return "User";
		}
		
		public String getRoleDescription()
		{
			return "Default application user.";
		}
	},
	
	;
	
	public String getRoleName()
	{
		throw new AssertionError("Should be accessed from the constant.");
	}
	
	public String getRoleDescription()
	{
		throw new AssertionError("Should be accessed from the constant.");
	}
}
