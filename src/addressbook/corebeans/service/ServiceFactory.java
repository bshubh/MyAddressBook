/**
 * 
 */
package addressbook.corebeans.service;

import java.util.HashMap;
import java.util.Map;

import addressbook.corebeans.serviceimpl.BusinessAddressImpl;
import addressbook.corebeans.serviceimpl.ContactServiceImpl;
import addressbook.corebeans.serviceimpl.HomeAddressServiceImpl;
import addressbook.corebeans.serviceimpl.PersonServiceImpl;
import addressbook.corebeans.serviceimpl.PersonalInformationImpl;
import addressbook.corebeans.serviceimpl.UserServiceImpl;

/**
 * @author Shubhashish Bhowmik
 *
 */
public enum ServiceFactory 
{
	INSTANCE;
	
	private static final Map<Class<? extends IPersistanceService>,Object> serviceMap = new HashMap<Class<? extends IPersistanceService>,Object>()
	{{
		put(IPersonService.class, new PersonServiceImpl());
		put(IContactService.class, new ContactServiceImpl());
		put(IUserService.class, new UserServiceImpl());
		put(IHomeAddressService.class, new HomeAddressServiceImpl());
		put(IBusinessAddressService.class, new BusinessAddressImpl());
		put(IPersonalInformationService.class, new PersonalInformationImpl());
		
	}};
	
	public <T> T getService(Class<?> clazz)
	{
		return (T) serviceMap.get(clazz);
	}
	
}
