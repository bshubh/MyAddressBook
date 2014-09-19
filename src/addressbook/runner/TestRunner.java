/**
 * 
 */
package addressbook.runner;

import java.util.List;

import addressbook.applicationbeans.ICardContext;
import addressbook.corebeans.Contact;
import addressbook.corebeans.Person;
import addressbook.corebeans.service.IBusinessAddressService;
import addressbook.corebeans.service.IContactService;
import addressbook.corebeans.service.IHomeAddressService;
import addressbook.corebeans.service.IPersonService;
import addressbook.corebeans.service.IPersonalInformationService;
import addressbook.corebeans.service.ServiceFactory;
import addressbook.vcardprocessor.CardProcessorVersion2;
import addressbook.vcardprocessor.CardProcessorVersion3;
import addressbook.vcardprocessor.CardProcessorVersion4;
import addressbook.vcardprocessor.IvCardProcessor;
import addressbook.vcardreader.ICardReader;
import addressbook.vcardreader.vCardReader;

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
			final IvCardProcessor version4Processor = new CardProcessorVersion4(); // last processor, as of now. 
			final IvCardProcessor version3Processor = new CardProcessorVersion3(version4Processor); // last processor, as of now. 
			final IvCardProcessor version2Processor = new CardProcessorVersion2(version3Processor); // last processor, as of now.
			
			final IPersonService personService = ServiceFactory.INSTANCE.getService(IPersonService.class);
			final IHomeAddressService homeAddressService = ServiceFactory.INSTANCE.getService(IHomeAddressService.class);
			final IBusinessAddressService businessAddressService = ServiceFactory.INSTANCE.getService(IBusinessAddressService.class);
			final IContactService contactService = ServiceFactory.INSTANCE.getService(IContactService.class);
			final IPersonalInformationService personalInfoService = ServiceFactory.INSTANCE.getService(IPersonalInformationService.class);
			
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
			}
			
			
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
