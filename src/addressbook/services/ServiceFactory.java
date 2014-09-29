/**
 * 
 */
package addressbook.services;

import addressbook.corebeans.persistence.AppSecurityDAO;
import addressbook.services.impl.BusinessAddressService;
import addressbook.services.impl.ContactService;
import addressbook.services.impl.HomeAddressService;
import addressbook.services.impl.PersonService;
import addressbook.services.impl.PersonalInfoService;
import addressbook.services.impl.UserRoleService;
import addressbook.services.impl.CardUserService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public enum ServiceFactory
{
	INSTANCE;
	
	/**
	 * @return {@link IUserService}
	 */
	public IUserService getUserService()
	{
		return (IUserService) getService(ServiceType.User, ServiceType.User.getAssociatedClass());
	}
	
	/**
	 * @return {@link IPersonService}
	 */
	public IPersonService getPersonService()
	{
		return (IPersonService) getService(ServiceType.Person, ServiceType.Person.getAssociatedClass());
	}
	
	/**
	 * @return {@link IContactService}.
	 */
	public IContactService getContactService()
	{
		return (IContactService) getService(ServiceType.Contact, ServiceType.Contact.getAssociatedClass());
	}
	
	/**
	 * @return {@link IPersonalInformationService}.
	 */
	public IPersonalInformationService getPersonalInformationService()
	{
		return (IPersonalInformationService) getService(ServiceType.PersonalInformation, ServiceType.PersonalInformation.getAssociatedClass());
	}
	
	/**
	 * @return {@link IBusinessAddressService}.
	 */
	public IBusinessAddressService getBusinessAddressService()
	{
		return (IBusinessAddressService) getService(ServiceType.BusinessAddress, ServiceType.BusinessAddress.getAssociatedClass());
	}
	
	/**
	 * @return {@link IHomeAddressService}.
	 */
	public IHomeAddressService getHomeAddressService()
	{
		return (IHomeAddressService) getService(ServiceType.HomeAddress, ServiceType.HomeAddress.getAssociatedClass());
	}
	
	/**
	 * @param type
	 * @param classname
	 * @return
	 */
	private <T> T getService(ServiceType type, Class<T> classname)
	{
		try
		{
			switch (type)
			{
				case Contact:
					return classname.cast(new ContactService());
				case User:
					return classname.cast(new CardUserService(getServiceDAO(AppSecurityDAO.class)));
				case BusinessAddress:
					return classname.cast(new BusinessAddressService());
				case HomeAddress:
					return classname.cast(new HomeAddressService());
				case Person:
					return classname.cast(new PersonService());
				case PersonalInformation:
					return classname.cast(new PersonalInfoService());
				case UserRole:
					return classname.cast(new UserRoleService());
				default:
					return null;
			}
		} 
		catch (InstantiationException e)
		{
			throw new RuntimeException(e.getLocalizedMessage());
		} 
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e.getLocalizedMessage());
		}
	}
	
	/**
	 * @param cls
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private <T> T getServiceDAO(Class<T> cls) throws InstantiationException, IllegalAccessException
	{
		return cls.newInstance();
	}
}
