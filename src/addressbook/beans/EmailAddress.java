/**
 * 
 */
package addressbook.beans;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class EmailAddress implements IEntity
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = -5012955555610249462L;

   private final String emailAdress;
   private boolean isDefault;
   
   /**
    * @param emailAdress
    */
   public EmailAddress(String emailAdress)
   {
      this.emailAdress = emailAdress;
   }

   /**
    * @return the isDefault
    */
   public boolean isDefault()
   {
      return isDefault;
   }

   /**
    * @param isDefault the isDefault to set
    */
   public void setDefault(boolean isDefault)
   {
      this.isDefault = isDefault;
   }

   /**
    * @return the emailAdress
    */
   public String getEmailAdress()
   {
      return emailAdress;
   }
   
   
}
