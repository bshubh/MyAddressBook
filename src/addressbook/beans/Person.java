/**
 * 
 */
package addressbook.beans;

import java.util.List;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class Person implements IEntity
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = -7252930236671040143L;
   
   
   private final String firstName;
   private final String middleName;
   private final String lastName;
   
   private String displayName;
   private String nickName;
   private List<EmailAddress> emailAddressList;
   
   /**
    * @param firstName
    * @param middleName
    * @param lastName
    */
   public Person(String firstName, String middleName, String lastName)
   {
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      
      displayName = lastName+", " + firstName;
   }

   /**
    * @return the nickName
    */
   public String getNickName()
   {
      return nickName;
   }

   /**
    * @param nickName the nickName to set
    */
   public void setNickName(String nickName)
   {
      this.nickName = nickName;
   }

   /**
    * @return the emailAddressList
    */
   public List<EmailAddress> getEmailAddressList()
   {
      return emailAddressList;
   }

   /**
    * @param emailAddressList the emailAddressList to set
    */
   public void setEmailAddressList(List<EmailAddress> emailAddressList)
   {
      this.emailAddressList = emailAddressList;
   }

   /**
    * @return the firstName
    */
   public String getFirstName()
   {
      return firstName;
   }

   /**
    * @return the middleName
    */
   public String getMiddleName()
   {
      return middleName;
   }

   /**
    * @return the lastName
    */
   public String getLastName()
   {
      return lastName;
   }

   /**
    * @return the displayName
    */
   public String getDisplayName()
   {
      return displayName;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
            + ", displayName=" + displayName + ", nickName=" + nickName + ", emailAddressList=" + emailAddressList
            + "]";
   }

   
}
