/**
 * 
 */
package addressbook.corebeans.serviceimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class ConnectionFactory 
{
	private final Semaphore semaphore;
	private final EntityManagerFactory entityFactory;

	private static final Map<Boolean,EntityManager> entityMangerMap = new HashMap<Boolean,EntityManager>(); 
	
	/**
	 * @param semaphore
	 */
	public ConnectionFactory() 
	{
		this.semaphore = new Semaphore(10);
		this.entityFactory = Persistence.createEntityManagerFactory("MyAddressBook");
	}
	
	/**
	 * @return
	 */
	public EntityManager getEntityManager()
	{
		EntityManager toreturn = null;
		
		try
		{
			semaphore.acquire();
			toreturn = getAvailableEntityManager();
		}
		catch(InterruptedException ignore)
		{
			ignore.printStackTrace();
		}
		
		return toreturn;
	}
	
	/**
	 * @param toRelease
	 */
	public void release(EntityManager toRelease)
	{
		try
		{
			putBack(toRelease);
		}
		finally
		{
			semaphore.release();
		}
	}
	
	/**
	 * @param toRelease
	 * @return
	 */
	private boolean putBack(EntityManager toRelease)
	{
		if(entityMangerMap.containsValue(toRelease))
		{
			entityMangerMap.put(Boolean.FALSE, toRelease);
		}
		return true;
	}

	/**
	 * @return
	 */
	private synchronized EntityManager getAvailableEntityManager()
	{
		EntityManager toreturn = null;
		if(entityMangerMap.isEmpty())
		{
			toreturn = this.entityFactory.createEntityManager();
			entityMangerMap.put(Boolean.TRUE,toreturn );
		}
		else if(entityMangerMap.containsKey(Boolean.FALSE))
		{
			toreturn = entityMangerMap.get(Boolean.FALSE);
		}
		return toreturn;
	}
}
