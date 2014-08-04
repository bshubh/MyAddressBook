/**
 * 
 */
package com.addressbook.beans;

import java.io.Serializable;

/**
 * @author Shubhashish Bhowmik
 *
 */
public abstract class AbstractGenericAddress implements Serializable
{
   
   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = 6773809489731210856L;
   
   protected final String streetAddress;
   protected final String city;
   protected final String stateProvince;
   protected final String Country;
   protected final String zipCode;
   protected String phoneNumber;
   protected String faxNumber;
   protected String mobileNumber;
   
   /**
    * @param streetAddress
    * @param city
    * @param stateProvince
    * @param country
    * @param zipCode
    */
   protected AbstractGenericAddress(String streetAddress,
         String city,
         String stateProvince,
         String country,
         String zipCode)
   {
      this.streetAddress = streetAddress;
      this.city = city;
      this.stateProvince = stateProvince;
      Country = country;
      this.zipCode = zipCode;
   }

   /**
    * @return the phoneNumber
    */
   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   /**
    * @param phoneNumber the phoneNumber to set
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   /**
    * @return the faxNumber
    */
   public String getFaxNumber()
   {
      return faxNumber;
   }

   /**
    * @param faxNumber the faxNumber to set
    */
   public void setFaxNumber(String faxNumber)
   {
      this.faxNumber = faxNumber;
   }

   /**
    * @return the mobileNumber
    */
   public String getMobileNumber()
   {
      return mobileNumber;
   }

   /**
    * @param mobileNumber the mobileNumber to set
    */
   public void setMobileNumber(String mobileNumber)
   {
      this.mobileNumber = mobileNumber;
   }

   /**
    * @return the streetAddress
    */
   public String getStreetAddress()
   {
      return streetAddress;
   }

   /**
    * @return the city
    */
   public String getCity()
   {
      return city;
   }

   /**
    * @return the stateProvince
    */
   public String getStateProvince()
   {
      return stateProvince;
   }

   /**
    * @return the country
    */
   public String getCountry()
   {
      return Country;
   }

   /**
    * @return the zipCode
    */
   public String getZipCode()
   {
      return zipCode;
   }
   
   
   
}
