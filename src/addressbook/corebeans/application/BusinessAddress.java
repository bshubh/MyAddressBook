/**
 * 
 */
package addressbook.corebeans.application;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Shubhashish Bhowmik
 *
 */
@Entity
@Table(name = "BusinessAddress")
@DiscriminatorValue(value = "BusinessAddress")
@Inheritance(strategy = InheritanceType.JOINED)
public class BusinessAddress extends AbstractGenericAddress
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = -7077813759345902533L;

   @Column(name = "CompanyName")
   private /*final*/ String companyName;
   
   @Column(name = "JobTitle")
   private String jobTitle;
   
   @Column(name = "Department")
   private String department;
   
   @Column(name ="Office")
   private String office;
   
   @Column(name = "WebpageURL")
   private String webPageURL;
   
   /**
    * 
    */
   public BusinessAddress(String streetaddress, 
                          String city, 
                          String stateprovince, 
                          String country, 
                          String zipcode, 
                          String companyname)
   {
      super(streetaddress, city, stateprovince, country, zipcode);
      this.companyName = companyname;
   }

   /**
    * @return the jobTitle
    */
   public String getJobTitle()
   {
      return jobTitle;
   }

   /**
    * @param jobTitle the jobTitle to set
    */
   public void setJobTitle(String jobTitle)
   {
      this.jobTitle = jobTitle;
   }

   /**
    * @return the department
    */
   public String getDepartment()
   {
      return department;
   }

   /**
    * @param department the department to set
    */
   public void setDepartment(String department)
   {
      this.department = department;
   }

   /**
    * @return the office
    */
   public String getOffice()
   {
      return office;
   }

   /**
    * @param office the office to set
    */
   public void setOffice(String office)
   {
      this.office = office;
   }

   /**
    * @return the webPageURL
    */
   public String getWebPageURL()
   {
      return webPageURL;
   }

   /**
    * @param webPageURL the webPageURL to set
    */
   public void setWebPageURL(String webPageURL)
   {
      this.webPageURL = webPageURL;
   }

   /**
    * @return the companyName as {@link String}
    */
   public String getCompanyName()
   {
      return companyName;
   }

	/**
	 * @return the id as {@link Long}.
	 */
	public Long getId() 
	{
		return identifier;
	}

	/**
	 * @param id the {@link Long} value to set.
	 */
	public void setId(Long id)
	{
		this.identifier = id;
	} 
   
}
