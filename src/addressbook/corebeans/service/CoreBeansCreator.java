/**
 * 
 */
package addressbook.corebeans.service;

import addressbook.applicationbeans.ICardContext;
import addressbook.applicationbeans.vCardDataBean;
import addressbook.corebeans.BusinessAddress;
import addressbook.corebeans.Contact;
import addressbook.corebeans.HomeAddress;
import addressbook.corebeans.IEntity;
import addressbook.corebeans.Person;
import addressbook.corebeans.PersonalInformation;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class CoreBeansCreator extends AbstractBeanCreator
{

	/**
	 * @param context
	 */
	public CoreBeansCreator(ICardContext context) 
	{
		super(context);
	}
	
	
	@Override
	public Contact call() throws Exception
	{
		final vCardDataBean dataBean = context.getDataBean();
		final Person person = createPerson(dataBean);
		final HomeAddress homeAddress = createHomeAddress(dataBean);
		final BusinessAddress businessAddress = createBusinessAddress(dataBean);
		final PersonalInformation personalInformation = createPersonalInformation(dataBean);
		
		final Contact contact = createContact(person);
		contact.setHomeAddress(homeAddress);
		contact.setBusinessAddress(businessAddress);
		contact.setPersonalInformation(personalInformation);
		
		return contact;
	}

	// TODO :: Create contact using builder.
	private Contact createContact(Person person)
	{
		Contact contact = new Contact(person);
		return contact;
	}
	
	private Person createPerson(vCardDataBean dataBean)
	{
		final Person person = new Person(dataBean.getFirstName(), dataBean.getMiddleName(), dataBean.getLastName());
		person.setNickName(dataBean.getNickName());
		// XXX :: Add the email address over here.
		return person;
	}
	
	private HomeAddress createHomeAddress(vCardDataBean dataBean)
	{
		//XXX :: Break the home address and get the streetname, city , strate, country and zip code.
		final HomeAddress homeAddress = new HomeAddress("", "", "", "", "");
		homeAddress.setPhoneNumber(dataBean.getHomeTelephoneNr());
		return homeAddress;
	}
	
	private BusinessAddress createBusinessAddress(vCardDataBean dataBean)
	{
		final BusinessAddress businessAddress = new BusinessAddress("", "", "", "", "",""); 
		businessAddress.setPhoneNumber(dataBean.getWorkTelephoneNr());
		return businessAddress;
	}
	
	
	private PersonalInformation createPersonalInformation(vCardDataBean dataBean) 
	{
		// TODO 
		return null;
	}
	
	// XXX : Complete this implementation
	private <T> T createBean(Class<T> clazz, vCardDataBean dataBean , IEntity argParameter )
	{
		
		return null;
	}


	
}
