/**
 * 
 */
package addressbook.services;

import addressbook.appbeans.ICardContext;
import addressbook.corebeans.application.Person;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IPersonService 
{
	Person createPerson(ICardContext context);
}
