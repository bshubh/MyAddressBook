/**
 * 
 */
package addressbook.corebeans.service;

import addressbook.applicationbeans.ICardContext;
import addressbook.corebeans.BusinessAddress;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IBusinessAddressService extends IPersistanceService<BusinessAddress>
{
	BusinessAddress createBusinessAddress(ICardContext context);
}
