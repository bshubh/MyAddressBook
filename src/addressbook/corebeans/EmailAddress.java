/**
 * 
 */
package addressbook.corebeans;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class EmailAddress implements IEntity
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = -5012955555610249462L;

   private final String emailAdress;
   private final boolean isDefault;
   
   /**
    * @param emailAdress
    */
   public EmailAddress(String emailAdress)
   {
      this(emailAdress,false);
   }

	/**
	 * @param emailAdress
	 * @param isDefault
	 */
	public EmailAddress(String emailAdress, boolean isDefault) 
	{
		this.emailAdress = emailAdress;
		this.isDefault = isDefault;
	}

/**
    * @return the isDefault
    */
   public boolean isDefault()
   {
      return isDefault;
   }

   /**
    * @return the emailAdress
    */
   public String getEmailAdress()
   {
      return emailAdress;
   }
   
   public static EmailAddress createEmailAddress(String emailaddress , boolean isdefault)
   {
	   return new EmailAddress(emailaddress,isdefault);
   }
}
