/**
 * 
 */
package addressbook.services.impl;

import addressbook.appbeans.ICardContext;
import addressbook.appbeans.vCardDataBean;
import addressbook.corebeans.application.HomeAddress;
import addressbook.services.IHomeAddressService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class HomeAddressService implements IHomeAddressService 
{


	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IHomeAddressService#createHomeAddress(addressbook.applicationbeans.ICardContext)
	 */
	@Override
	public HomeAddress createHomeAddress(ICardContext context)
	{
		vCardDataBean dataBean = context.getDataBean();
		// XXX :: Break the home address and get the streetname, city , strate,
		// country and zip code.
		final HomeAddress homeAddress = new HomeAddress("", "", "", "", "");
		homeAddress.setPhoneNumber(dataBean.getHomeTelephoneNr());
		return homeAddress;
	}

}
