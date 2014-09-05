/**
 * 
 */
package addressbook.applicationbeans;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import addressbook.corebeans.Contact;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class UserImpl implements IUser
{

   /** Eclipse generated serialVersionUID.*/
   private static final long serialVersionUID = 5661859567194863937L;
   
   private Date lastLoginDate;
   private Date lastSyncDate;
   
   private IUserRole assignedRole;
   
   private boolean isActive;
   
   private List<Contact> allContacts = new LinkedList<Contact>();

}
