/**
 * 
 */
package addressbook.corebeans.application;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import addressbook.corebeans.interfaces.IEntity;

/**
 * This class will hold the personal information about a {@link Contact} or a {@link Person}.
 * 
 * @author Shubhashish Bhowmik
 *
 */
@Entity
@Table( name = "PersonalInformation")
public class PersonalInformation implements IEntity
{
   /** Eclipse generated serialVersionUID. */
   private static final long serialVersionUID = -8764487899905405369L;

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private long identifier;
   
   public enum Gender
   {
      MALE("Male"),
      FEMALE("Female");
      
      private String strRepresentation;
      
      Gender(String name)
      {
    	  strRepresentation = name;
      }
      
      public String toString()
      {
    	  return strRepresentation;
      }
   }
   
   @Column(name = "SpouseName")
   private String spouseName;
   
  /* @Column
   private List<String> children = new LinkedList<String>( );*/
   
   @Column(name = "Gender")
   private Gender gender;
   
   @Column(name = "BirthDate")
   private Date birthDate;
   
   @Column(name = "AniversaryDate")
   private Date aniversaryDate;
   
   /**
    * @return the spouseName
    */
   public String getSpouseName()
   {
      return spouseName;
   }
   /**
    * @param spouseName the spouseName to set
    */
   public void setSpouseName(String spouseName)
   {
      this.spouseName = spouseName;
   }
   
   /**
    * @return the children
    *//*
   public List<String> getChildren()
   {
      return children;
   }
   
   *//**
    * @param children the children to set
    *//*
   public void setChildren(String child)
   {
      if(! children.contains( child ))
      {
         children.add(child);
      }
   }*/
   
   /**
    * @return the gender
    */
   public Gender getGender()
   {
      return gender;
   }
   
	/**
	 * @return {@link String} representation of the {@link Gender}.
	 */
	public String getGenderAsString()
	{
		return gender.toString();
	}
   
   /**
    * @param gender the gender to set
    */
   public void setGender(Gender gender)
   {
      this.gender = gender;
   }
   
   /**
    * @return the birthDate
    */
   public Date getBirthDate()
   {
      return birthDate;
   }
   
   /**
    * @param birthDate the birthDate to set
    */
   public void setBirthDate(Date birthDate)
   {
      this.birthDate = birthDate;
   }
   
   /**
    * @return the aniversaryDate
    */
   public Date getAniversaryDate()
   {
      return aniversaryDate;
   }
   
   /**
    * @param aniversaryDate the aniversaryDate to set
    */
   public void setAniversaryDate(Date aniversaryDate)
   {
      this.aniversaryDate = aniversaryDate;
   }

	/**
	 * @return the id
	 */
	public long getId() 
	{
		return identifier;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) 
	{
		this.identifier = id;
	}
   
   
}
