package addressbook.corebeans.persistence;

import addressbook.corebeans.interfaces.ICardUser;
import addressbook.corebeans.security.CardUser;


public interface IAppSecurityDAO extends IPersistanceService<CardUser>
{
	boolean checkAppAdmin();
	
	ICardUser getAdminUser();
}
