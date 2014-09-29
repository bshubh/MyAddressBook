package addressbook.services;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import addressbook.corebeans.persistence.AppSecurityDAO;
import addressbook.corebeans.persistence.IAppSecurityDAO;
import addressbook.corebeans.security.CardUser;
import addressbook.services.impl.CardUserService;


/**
 * Test class
 * 
 * Class under test : {@link CardUserService}.
 * @author Shubhashish Bhowmik
 *
 */
public class CardUserServiceTest
{
	private final IAppSecurityDAO userDAO;
	
	
	public CardUserServiceTest()
	{
		this.userDAO = new AppSecurityDAO();
	}

	@Test
	public void testCreateAppUser()
	{
		try
		{
			final CardUser cardUser = new CardUser("carduser", "carduser");
			cardUser.setActive(true);
			cardUser.setApplicationAdmin(false);
			cardUser.setLastLoginDate(Calendar.getInstance().getTime());
			cardUser.setSystemAdministrator(false);
			userDAO.commit(cardUser);
			
			Assert.assertEquals(cardUser, cardUser);
			Assert.assertTrue(cardUser.isActive());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}


}
