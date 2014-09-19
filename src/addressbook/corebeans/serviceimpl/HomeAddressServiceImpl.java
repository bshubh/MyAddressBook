/**
 * 
 */
package addressbook.corebeans.serviceimpl;

import addressbook.applicationbeans.ICardContext;
import addressbook.applicationbeans.vCardDataBean;
import addressbook.corebeans.HomeAddress;
import addressbook.corebeans.service.IHomeAddressService;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class HomeAddressServiceImpl extends AbstractPersistanceService<HomeAddress> implements IHomeAddressService 
{

	
	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#commit(java.lang.Object)
	 */
	@Override
	public boolean commit(HomeAddress entityToCommit) 
	{
		return super.commit(entityToCommit);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(HomeAddress entityToDelete)
	{
		super.delete(entityToDelete);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#find(java.lang.Object)
	 */
	@Override
	public HomeAddress find(Object objToFind) 
	{
		return super.find(objToFind);
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.dao.IGenericDAO#update(java.lang.Object)
	 */
	@Override
	public HomeAddress update(HomeAddress objToUpdate)
	{
		return super.update(objToUpdate);
	}

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
