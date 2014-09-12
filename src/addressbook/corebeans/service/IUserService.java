/**
 * 
 */
package addressbook.corebeans.service;

import addressbook.corebeans.IUser;

/**
 * User service with dao capabiltiy.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public interface IUserService extends IPersistanceService<IUser>
{
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	IUser createUser(String username, String password);
	
	/**
	 * @param username
	 * @return
	 */
	IUser getUserByName(String username);
}
