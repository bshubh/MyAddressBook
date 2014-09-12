/**
 * 
 */
package addressbook.corebeans.service;

import java.util.HashMap;
import java.util.Map;

import addressbook.corebeans.serviceimpl.ContactServiceImpl;
import addressbook.corebeans.serviceimpl.PersonServiceImpl;
import addressbook.corebeans.serviceimpl.UserServiceImpl;

/**
 * @author Shubhashish Bhowmik
 *
 */
public enum ServiceFactory 
{
	INSTANCE
	{
		
	};
	
	private static final Map<Class<? extends IPersistanceService>,Object> serviceMap = new HashMap<Class<? extends IPersistanceService>,Object>()
	{{
		put(IPersonService.class, new PersonServiceImpl());
		put(IContactService.class, new ContactServiceImpl());
		put(IUserService.class, new UserServiceImpl());
	}};
	
	private ServiceFactory()
	{
		
	}
	
	public <T> T getService(Class<?> clazz)
	{
		return (T) serviceMap.get(clazz);
	}
	
	
	public static void main(String[] args) 
	{
		IPersonService person = ServiceFactory.INSTANCE.getService(IPersonService.class);
		System.out.println(person);
	}
}
