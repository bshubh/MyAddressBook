/**
 * 
 */
package com.addressbook.beans;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class HomeAddress extends AbstractGenericAddress
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = 1402849135685655909L;

   private String webPageURL;
   
   /**
    * 
    */
   public HomeAddress(String streetaddress, String city, String stateprovince, String country, String zipcode)
   {
      super(streetaddress, city, stateprovince, country, zipcode);
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

   
}
