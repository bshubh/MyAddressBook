/**
 * 
 */
package addressbook.corebeans;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This class will be responsible for handling the all the <code>Contact</code>. 
 * 
 * @author Shubhashish Bhowmik
 *
 */
@Entity
@Table(name = "Contact")
public class Contact implements IEntity
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = -5967939392206495125L;

   @Id
   private Long identifier;
   
   @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
   private /*final*/ Person person;
   
   @OneToOne(fetch = FetchType.LAZY)
   private IUser user;
   
   @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private HomeAddress homeAddress;
   
   @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private BusinessAddress businessAddress;
   
   @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private PersonalInformation personalInformation;
   
   /**
    * Parameterize constructor
    * @param person {@link Person}, cannot be <code>null</code>
    */
   public Contact(Person person)
   {
      this.person = person;
      identifier = System.currentTimeMillis();
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

	/**
	 * @return the user
	 */
	public IUser getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(IUser user)
	{
		this.user = user;
	}

	/**
	 * @return the identifier
	 */
	public Long getIdentifier() 
	{
		return identifier;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object anotherContact)
	{
		if (this == anotherContact)
			return true;
		if (anotherContact == null)
			return false;
		if (getClass() != anotherContact.getClass())
			return false;
		Contact other = (Contact) anotherContact;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		return true;
	}

	
   
   
}
