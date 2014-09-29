/**
 * 
 */
package addressbook.runner;

import addressbook.corebeans.interfaces.ICardUser;
import addressbook.services.IUserService;
import addressbook.services.ServiceFactory;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class TestRunner 
{

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			
			//final IPersonService personService = (IPersonService) ServiceFactory.createInstance(IPersonService.class).createPersistenceService();
			//final IHomeAddressService homeAddressService = ServiceFactory.createInstance(IHomeAddressService.class, HomeAddress.class).createPersistenceService();
			//final IBusinessAddressService businessAddressService = ServiceFactory.createInstance(IBusinessAddressService.class, BusinessAddress.class).createPersistenceService();
			//final IContactService contactService = ServiceFactory.createInstance(IContactService.class, Contact.class).createPersistenceService();
			//final IPersonalInformationService personalInfoService = ServiceFactory.createInstance(IPersonalInformationService.class, PersonalInformation.class).createPersistenceService();
			final IUserService userService = ServiceFactory.INSTANCE.getUserService();
			
			ICardUser adminUser = userService.createAppAdmin();
			
			System.out.println(adminUser.getIdentifier());
			
			/*final IvCardProcessor version4Processor = new CardProcessorVersion4(); // last processor, as of now. 
			final IvCardProcessor version3Processor = new CardProcessorVersion3(version4Processor); // last processor, as of now. 
			final IvCardProcessor version2Processor = new CardProcessorVersion2(version3Processor); // last processor, as of now.
			
			final ICardReader reader = new vCardReader("PIM00005.vcf");
			final List<ICardContext> cardDataList = reader.readCardData();
			
			for (ICardContext cardContext : cardDataList)
			{
				version2Processor.parseCardData(cardContext);
				final Person person = personService.createPerson(cardContext);
				final Contact contact = contactService.createContact(person);
				contact.setBusinessAddress(businessAddressService.createBusinessAddress(cardContext));
				contact.setHomeAddress(homeAddressService.createHomeAddress(cardContext));
				contact.setPersonalInformation(personalInfoService.createPersonalInformation(cardContext));
				contactService.commit(contact);
				System.out.println(person);
			}*/
			
			
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void runSampleCardTest()
	{
		
	}

}
