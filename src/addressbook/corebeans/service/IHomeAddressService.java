/**
 * 
 */
package addressbook.corebeans.service;

import addressbook.applicationbeans.ICardContext;
import addressbook.corebeans.AbstractGenericAddress;
import addressbook.corebeans.HomeAddress;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IHomeAddressService extends IPersistanceService<HomeAddress>
{
	HomeAddress createHomeAddress(ICardContext context);
	
}
