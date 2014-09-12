/**
 * 
 */
package addressbook.corebeans.service;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * @author Shubhashish Bhowmik
 *
 */
public abstract class AbstractPersistanceService<T> implements IPersistanceService<T> 
{

	protected final EntityManager entityManager;
	protected final EntityManagerFactory managerFactory;
	
	private final Class<T> classType;
	
	/**
	 * 
	 */
	protected AbstractPersistanceService() 
	{
		ParameterizedType parameterizeType = (ParameterizedType) getClass().getGenericSuperclass();
		classType = ((Class) parameterizeType.getActualTypeArguments()[0]); // first one
		managerFactory = Persistence.createEntityManagerFactory("MyAddressBook");
		entityManager = managerFactory.createEntityManager();
		
	}

	@Override
	public boolean commit(T entityToCommit)
	{
		entityManager.persist(entityToCommit);
		return true;
	}

	@Override
	public void delete(T entityToDelete)
	{
		entityManager.remove(entityToDelete);
	}

	@Override
	public T find(Object objToFind) 
	{
		return entityManager.find(classType, objToFind);
	}

	@Override
	public T update(T objToUpdate)
	{
		return entityManager.merge(objToUpdate);
	}

}
