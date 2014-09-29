/**
 * 
 */
package addressbook.services;

import addressbook.corebeans.application.Person;
import addressbook.corebeans.application.PersonalInformation;
import addressbook.corebeans.interfaces.ICardUser;
import addressbook.corebeans.interfaces.IUserRole;
import addressbook.corebeans.security.UserRole;

/**
 * User service 
 * 
 * @author Shubhashish Bhowmik
 *
 */
public interface IUserService 
{
	
	/**
	 * This method will create the application administrator user for the first time.
	 * If <code>Administrator</code> already exists then it will return the Application {@link ICardUser}
	 * other it will create a new <code>Administrator</code> user and send back the {@link ICardUser} back to the user.
	 * 
	 * @return {@link ICardUser} as <code> Administrator</code>.
	 */
	ICardUser createAppAdmin();
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	ICardUser createAppUser(String username, String password);
	
	/**
	 * @param username
	 * @return
	 */
	ICardUser getUserByName(String username);
	
	/**
	 * @param personInfo
	 * @return
	 */
	boolean addPersonalInformation(ICardUser user, PersonalInformation personInfo);
	
	/**
	 * @param person
	 * @return
	 */
	boolean setPerson(ICardUser user, Person person);
	
	/**
	 * @param toAdd
	 * @return
	 */
	boolean addUserRole(ICardUser user,UserRole toAdd);
	
	/**
	 * @param toRemove
	 * @return
	 */
	boolean removeUserRole(ICardUser user,IUserRole toRemove);
}
 