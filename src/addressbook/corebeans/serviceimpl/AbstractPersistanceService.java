/**
 * 
 */
package addressbook.corebeans.serviceimpl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import addressbook.corebeans.service.IPersistanceService;


/**
 * @author Shubhashish Bhowmik
 *
 */
public abstract class AbstractPersistanceService<T> implements IPersistanceService<T> 
{

	protected EntityManager entityManager;
	//protected final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("MyAddressBook");
	protected final ConnectionFactory managerFactory = new ConnectionFactory();
	
	private final Class<T> classType;
	
	/**
	 * Default constructor for initializing the persistence.
	 */
	protected AbstractPersistanceService() 
	{
		ParameterizedType parameterizeType = (ParameterizedType) getClass().getGenericSuperclass();
		classType = ((Class) parameterizeType.getActualTypeArguments()[0]); // first one
	}

	@Override
	public boolean commit(T entityToCommit)
	{
		entityManager = managerFactory.getEntityManager();
		final EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(entityToCommit);
		entityTransaction.commit();
		managerFactory.release(entityManager);
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
