/**
 * 
 */
package addressbook.beans;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class User implements IEntity
{

   /** Eclipse generated serialVersionUID.*/
   private static final long serialVersionUID = 5661859567194863937L;
   
   private Date lastLoginDate;
   private Date lastSyncDate;
   
   private List<Contact> allContacts = new LinkedList<Contact>();

}
