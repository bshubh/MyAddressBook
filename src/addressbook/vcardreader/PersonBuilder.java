package addressbook.vcardreader;

import addressbook.beans.Person;

/**
 * Normal builder, not an immutable one to generate an Instance of {@link Person} class.
 * @author Shubhashish Bhowmik
 *
 */
public final class PersonBuilder
{
   //private final String familyName, givenName;
   private final Person person;

   /**
    * @param person
    */
   public PersonBuilder(String familyName, String givenName)
   {
      this(familyName,null,givenName);
   }
   
   public PersonBuilder( String familyName, String middleName, String givenName)
   {
      this.person = new Person(familyName,middleName,givenName);
   }
   
   /**
    * @param vcard
    * @return
    */
   public PersonBuilder addEmailAddress( /*final Iterator<EmailFeature> emailItr */)
   {
     /* Utility.assertNotNull( emailItr, "Email iterator is be null" );
      
      final List<EmailAddress> emailAddressList = new LinkedList<EmailAddress>();
      while( emailItr.hasNext( ))
      {
         EmailFeature emailfeature = emailItr.next( );
         emailAddressList.add( new EmailAddress(emailfeature.getEmail( )) );
      }
      person.setEmailAddressList( emailAddressList );*/
      
      return this;
   }
   
   /**
    * @param nicknameFeature
    * @return
    */
   public PersonBuilder addNickname( /*final NicknameFeature nicknameFeature*/)
   {
      try
      {
         /*Utility.assertNotNull( nicknameFeature, "Nick name feature is null, hence no nick names" );
         
         final NicknameType nickName = (NicknameType)nicknameFeature;
         final Iterator<String> nicknamesItr = nickName.getNicknames( );
         final StringBuffer nickNameBuff = new StringBuffer( 10 );
         while(nicknamesItr.hasNext( ))
         {
            nickNameBuff.append( nicknamesItr.next( ) ) ;
         }
         
         person.setNickName( nickNameBuff.toString( ) );*/
      }
      catch (Exception ignore)
      {
         // XXX:: LOgger implementation
         //e.printStackTrace();
      }
      
      return this;
   }
   
   public Person build()
   {
      return person;
   }
}
