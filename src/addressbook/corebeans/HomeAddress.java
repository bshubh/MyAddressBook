/**
 * 
 */
package addressbook.corebeans;

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
@Table(name = "HomeAddress")
@DiscriminatorValue(value = "HomeAddress")
@Inheritance(strategy = InheritanceType.JOINED)
public class HomeAddress extends AbstractGenericAddress
{

   /** Eclipse generated serialVersionUID */
   private static final long serialVersionUID = 1402849135685655909L;

   @Column(name = "WebPageURL")
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
