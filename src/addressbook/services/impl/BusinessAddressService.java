/**
 * 
 */
package addressbook.services.impl;

import addressbook.appbeans.ICardContext;
import addressbook.appbeans.vCardDataBean;
import addressbook.corebeans.application.BusinessAddress;
import addressbook.services.IBusinessAddressService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class BusinessAddressService implements IBusinessAddressService 
{

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IBusinessAddressService#createBusinessAddress(addressbook.applicationbeans.ICardContext)
	 */
	@Override
	public BusinessAddress createBusinessAddress(ICardContext context)
	{
		vCardDataBean dataBean = context.getDataBean();
		final BusinessAddress businessAddress = new BusinessAddress("", "", "", "", "",""); 
		businessAddress.setPhoneNumber(dataBean.getWorkTelephoneNr());
		return businessAddress;
	}

}
