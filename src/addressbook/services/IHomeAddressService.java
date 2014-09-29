/**
 * 
 */
package addressbook.services;

import addressbook.appbeans.ICardContext;
import addressbook.corebeans.application.HomeAddress;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IHomeAddressService 
{
	HomeAddress createHomeAddress(ICardContext context);
	
}
