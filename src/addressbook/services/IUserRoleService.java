/**
 * 
 */
package addressbook.services;

import addressbook.corebeans.interfaces.IUserRole;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IUserRoleService 
{
	IUserRole createUserRole(String roleName, String desc);
}
