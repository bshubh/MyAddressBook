/**
 * 
 */
package addressbook.corebeans.helpers;

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
public class CoreBeansCreator
{
	private final ICardContext context;

	/**
	 * @param context
	 */
	public CoreBeansCreator(ICardContext context) 
	{
		this.context = context;
	}
	
	public void createCoreBeans()
	{
		final vCardDataBean dataBean = context.getDataBean();
		final Person person = createPerson(dataBean);
		final HomeAddress homeAddress = createHomeAddress(dataBean);
		final BusinessAddress businessAddress = createBusinessAddress(dataBean);
		final PersonalInformation personalInformation = createPersonalInformation(dataBean);
		
		final Contact contact = createContact(person);
		
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
		String homeAddress = dataBean.getHomeAddress();
		//XXX :: Break the home address and get the streetname, city , strate, country and zip code.
		return null;
	}
	
	private BusinessAddress createBusinessAddress(vCardDataBean dataBean)
	{
		// TODO 
		return null;
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
