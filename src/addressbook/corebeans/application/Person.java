/**
 * 
 */
package addressbook.corebeans.application;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import addressbook.corebeans.interfaces.IEntity;

/**
 * This class will be responsible for holding the basic information of a person, hence {@link Person} class.
 * 
 *  Earlier this class is immutable which make jpa to skip the final fields to commit into the database.
 *  Hence changing them from 
 * 
 * @author Shubhashish Bhowmik
 *
 */
@Entity
@Table(name = "Person")
public class Person implements IEntity
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = -7252930236671040143L;
   
   @Id
   private /*final*/ long identifier;
   
   @Column(name = "FirstName")
   private /*final*/ String firstName;
   
   @Column(name = "MiddleName")
   private /*final*/ String middleName;
   
   @Column(name = "LastName")
   private /*final*/ String lastName;
   
   @Column(name = "DisplayName")
   private String displayName;
   
   @Column (name = "NickName")
   private String nickName;
   
   @OneToMany( fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
   private /*final*/ LinkedList<EmailAddress> emailAddressList = new LinkedList<EmailAddress>();
   
   /*@OneToOne(mappedBy="carduser")
   
   private CardUser carduser;*/
   
   /**
    * Parameterize constructor for creating {@link Person}.
    * 
    * @param firstName as {@link String}
    * @param middleName as {@link String}
    * @param lastName as {@link String}
    */
   public Person(String firstName, String middleName, String lastName)
   {
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      
      displayName = lastName+", " + firstName;
      identifier = System.currentTimeMillis();
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
      return Collections.unmodifiableList(emailAddressList);
   }
   
	/**
	 * @param emailAddress
	 * @param isDefault
	 */
	public void setEmailAddressList(String emailAddress, boolean isDefault)
	{
		if (emailAddressList.isEmpty())
		{
			emailAddressList.add(EmailAddress.createEmailAddress(emailAddress,isDefault));
		} 
		else 
		{
			emailAddressList.addLast(EmailAddress.createEmailAddress(emailAddress, isDefault));
		}
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

   
   
	/**
	 * @return the identifier
	 */
	public long getIdentifier()
	{
		return identifier;
	}

	/**
	 * @param identifier
	 *            the identifier to set
	 */
	public void setIdentifier(long identifier)
	{
		this.identifier = identifier;
	}

/* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Person [	" +
      					"UUID=" + identifier + ", " +
      					"firstName=" + firstName + ", " +
      					"middleName=" + middleName + ", " +
      					"lastName=" + lastName + ", " +
      					"displayName=" + displayName + ", " +
      					"nickName=" + nickName + ", " +
      					"emailAddressList=" + emailAddressList
            + "]";
   }

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (identifier ^ (identifier >>> 32));
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
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Person))
		{
			return false;
		}
		Person other = (Person) obj;
		if (identifier != other.identifier)
		{
			return false;
		}
		return true;
	}


   
}
