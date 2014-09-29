/**
 * 
 */
package addressbook.services;

import addressbook.appbeans.ICardContext;
import addressbook.corebeans.application.BusinessAddress;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IBusinessAddressService 
{
	BusinessAddress createBusinessAddress(ICardContext context);
}
