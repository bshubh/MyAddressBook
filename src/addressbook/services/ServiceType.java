/**
 * 
 */
package addressbook.services;

/**
 * @author Shubhashish Bhowmik
 *
 */
public enum ServiceType
{
	Person(IPersonService.class),
	Contact(IContactService.class),
	BusinessAddress(IBusinessAddressService.class),
	HomeAddress(IHomeAddressService.class),
	UserRole(IUserRoleService.class),
	User(IUserService.class),
	PersonalInformation(IPersonalInformationService.class)
	;
	
	private Class<?> associatedClass;

	/**
	 * @param associatedClass
	 */
	private ServiceType(Class<?> associatedClass)
	{
		this.associatedClass = associatedClass;
	}
	
	public Class<?> getAssociatedClass()
	{
		return associatedClass;
	}
}
