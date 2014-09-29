/**
 * 
 */
package addressbook.services;

import addressbook.appbeans.ICardContext;
import addressbook.corebeans.application.PersonalInformation;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IPersonalInformationService 
{
	PersonalInformation createPersonalInformation(ICardContext context);
}
