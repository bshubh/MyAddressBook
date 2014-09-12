/**
 * 
 */
package addressbook.corebeans.service;

import addressbook.applicationbeans.ICardContext;
import addressbook.corebeans.Person;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IPersonService extends IPersistanceService<Person>
{
	Person createPerson(ICardContext context);
}
