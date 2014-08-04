/**
 * 
 */
package com.addressbook.beans;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class PersonalInformation implements IEntity
{
   /** Eclipse generated serialVersionUID. */
   private static final long serialVersionUID = -8764487899905405369L;

   enum Gender
   {
      MALE,
      FEMALE
   }
   
   private String spouseName;
   private List<String> children = new LinkedList<String>( );
   
   private Gender gender;
   private Date birthDate;
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
    */
   public List<String> getChildren()
   {
      return children;
   }
   
   /**
    * @param children the children to set
    */
   public void setChildren(String child)
   {
      if(! children.contains( child ))
      {
         children.add(child);
      }
   }
   
   /**
    * @return the gender
    */
   public Gender getGender()
   {
      return gender;
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
}
