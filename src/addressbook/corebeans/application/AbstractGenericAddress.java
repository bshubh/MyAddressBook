/**
 * 
 */
package addressbook.corebeans.application;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import addressbook.corebeans.interfaces.IEntity;


/**
 * Abstract class to hold all the address parameters that are needed to make either {@link BusinessAddress} or {@link HomeAddress}.
 * 
 * Remove the <code>final</code> keyword, other JPA wont persists it.
 * 
 * @author Shubhashish Bhowmik
 *
 */
@MappedSuperclass
public abstract class AbstractGenericAddress implements IEntity
{
   
   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = 6773809489731210856L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected long identifier;
   
   @Column(name = "StreetAddress")
   protected /*final*/ String streetAddress;
   
   @Column(name = "City")
   protected /*final*/ String city;
   
   @Column(name = "State")
   protected /*final*/ String stateProvince;
   
   @Column(name = "Country")
   protected /*final */String Country;
   
   @Column(name = "Zipcode")
   protected /*final*/ String zipCode;
   
   @Column(name = "Phonenumber")
   protected String phoneNumber;
   
   @Column(name = "faxnumber")
   protected String faxNumber;
   
   @Column(name = "Mobilenumber")
   protected String mobileNumber;
   
   /**
    * Parameterize constructor for adding the address elements.
    * 
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
      this.Country = country;
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
		if (!(obj instanceof AbstractGenericAddress))
		{
			return false;
		}
		AbstractGenericAddress other = (AbstractGenericAddress) obj;
		if (identifier != other.identifier)
		{
			return false;
		}
		return true;
	}
   
   
   
}
