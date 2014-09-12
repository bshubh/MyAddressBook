/**
 * 
 */
package addressbook.corebeans.service;

import addressbook.applicationbeans.ICardContext;
import addressbook.corebeans.PersonalInformation;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IPersonalInformationService extends IPersistanceService<PersonalInformation>
{
	PersonalInformation createPersonalInformation(ICardContext context);
}
