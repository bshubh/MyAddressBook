/**
 * 
 */
package addressbook.corebeans;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class Contact implements IEntity
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = -5967939392206495125L;

   private final Person person;
   private HomeAddress homeAddress;
   private BusinessAddress businessAddress;
   private PersonalInformation personalInformation;
   
   /**
    * Parameterize constructor
    * @param person {@link Person}, cannot be <code>null</code>
    */
   public Contact(Person person)
   {
      this.person = person;
   }

   /**
    * @return the homeAddress
    */
   public HomeAddress getHomeAddress()
   {
      return homeAddress;
   }

   /**
    * @param homeAddress the homeAddress to set
    */
   public void setHomeAddress(HomeAddress homeAddress)
   {
      this.homeAddress = homeAddress;
   }

   /**
    * @return the businessAddress
    */
   public BusinessAddress getBusinessAddress()
   {
      return businessAddress;
   }

   /**
    * @param businessAddress the businessAddress to set
    */
   public void setBusinessAddress(BusinessAddress businessAddress)
   {
      this.businessAddress = businessAddress;
   }

   /**
    * @return the personalInformation
    */
   public PersonalInformation getPersonalInformation()
   {
      return personalInformation;
   }

   /**
    * @param personalInformation the personalInformation to set
    */
   public void setPersonalInformation(PersonalInformation personalInformation)
   {
      this.personalInformation = personalInformation;
   }

   /**
    * @return the person
    */
   public Person getPerson()
   {
      return person;
   }
   
   
}
