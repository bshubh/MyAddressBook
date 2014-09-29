/**
 * 
 */
package addressbook.services.impl;

import addressbook.appbeans.ICardContext;
import addressbook.appbeans.vCardDataBean;
import addressbook.corebeans.application.Person;
import addressbook.services.IPersonService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class PersonService implements IPersonService
{


	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IPersonService#createPerson(addressbook.applicationbeans.ICardContext)
	 */
	@Override
	public Person createPerson(ICardContext context)
	{
		final vCardDataBean dataBean = context.getDataBean();
		final Person person = new Person(dataBean.getFirstName(), dataBean.getMiddleName(), dataBean.getLastName());
		person.setNickName(dataBean.getNickName());
		person.setEmailAddressList("sbhowmik@abc.zzz", true);
		// XXX :: Add the email address over here.
		return person;
	}

}
