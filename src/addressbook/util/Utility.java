/**
 * 
 */
package addressbook.util;

/**
 * @author Shubhashish Bhowmik
 *
 */
public final class Utility
{

   /**
    * 
    */
   public Utility()
   {
      throw new AssertionError( "Utility class should be invoked using the class level methods" );
   }
   
   /**
    * @param object
    * @return
    */
   public static <T>T assertNotNull(final T object, final String errorMessage )
   {
      if ( object == null )
      {
         //throw new IllegalArgumentException(errorMessage);
         System.out.println( "Utility.assertNotNull()" + errorMessage );
      }
      return object;
   }
}
