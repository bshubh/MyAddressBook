/**
 * 
 */
package addressbook.corebeans.serviceimpl;

import addressbook.applicationbeans.ICardContext;
import addressbook.applicationbeans.vCardDataBean;
import addressbook.corebeans.BusinessAddress;
import addressbook.corebeans.service.AbstractPersistanceService;
import addressbook.corebeans.service.IBusinessAddressService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class BusinessAddressImpl extends AbstractPersistanceService<BusinessAddress> implements IBusinessAddressService 
{

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IGenericDAO#commit(java.lang.Object)
	 */
	@Override
	public boolean commit(BusinessAddress entityToCommit) 
	{
		return super.commit(entityToCommit);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IGenericDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(BusinessAddress entityToDelete)
	{
		super.delete(entityToDelete);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IGenericDAO#find(java.lang.Object)
	 */
	@Override
	public BusinessAddress find(Object objToFind)
	{
		return super.find(objToFind);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.service.IGenericDAO#update(java.lang.Object)
	 */
	@Override
	public BusinessAddress update(BusinessAddress objToUpdate) 
	{
		return super.update(objToUpdate);
	}

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
