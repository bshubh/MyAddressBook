/**
 * 
 */
package com.addressbook.beans;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class BusinessAddress extends AbstractGenericAddress
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = -7077813759345902533L;

   private final String companyName;
   private String jobTitle;
   private String department;
   private String office;
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
    * @return the companyName
    */
   public String getCompanyName()
   {
      return companyName;
   }
   
   
}
