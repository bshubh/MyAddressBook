/**
 * 
 */
package addressbook.corebeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class will be responsible for holding the <code>Email address </code>.
 * 
 * @author Shubhashish Bhowmik
 *
 */
@Entity
@Table(name = "EmailAddress")
public class EmailAddress implements IEntity
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = -5012955555610249462L;

   @Id
   private /*final*/ long id;
   
   @Column(name = "EmailAddress")
   private /*final*/ String emailAdress;
   
   @Column(name = "default")
   private /*final*/ boolean isDefault;
   
   /**
    * Parameterize constructor.
    * 
    * @param emailAdress as {@link String}.
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
		this.id = System.currentTimeMillis();
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

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailAddress other = (EmailAddress) obj;
		if (id != other.id)
			return false;
		return true;
	}
   
}
