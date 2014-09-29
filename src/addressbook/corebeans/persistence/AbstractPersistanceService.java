/**
 * 
 */
package addressbook.corebeans.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;



/**
 * Abstract class implementing the {@link IPersistanceService}.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public abstract class AbstractPersistanceService<T> implements IPersistanceService<T> 
{

	protected EntityManager entityManager;
	//protected final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("MyAddressBook");
	protected final ConnectionFactory managerFactory = new ConnectionFactory();
	
	protected final Class<T> entityClass;
	
	/**
	 * Default constructor for initializing the persistence.
	 */
	@SuppressWarnings("unchecked")
	protected AbstractPersistanceService() 
	{
		ParameterizedType parameterizeType = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = ((Class<T>) parameterizeType.getActualTypeArguments()[0]); // first one
	}
	
	/**
	 * @return the <code>T</code> implementation.
	 */
	protected Class<T> getEntityClass()
	{
		return entityClass;
	}

	/**
	 * @return {@link EntityManager}.
	 */
	protected EntityManager getEntityManager()
	{
		if(entityManager == null)
		{
			entityManager = managerFactory.getEntityManager();
		}
		return entityManager;
	}
	
	/**
	 * @param {@link EntityManager} to release.
	 */
	protected void releaseEntityManager(EntityManager torelease)
	{
		managerFactory.release(torelease);
	}
	
	
	@Override
	public boolean commit(T entityToCommit)
	{
		entityManager = managerFactory.getEntityManager();
		final EntityTransaction entityTransaction = getEntityManager().getTransaction();
		entityTransaction.begin();
		entityManager.persist(entityToCommit);
		entityTransaction.commit();
		managerFactory.release(entityManager);
		return true;
	}

	@Override
	public void delete(T entityToDelete)
	{
		entityManager = managerFactory.getEntityManager();
		final EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityToDelete);
		entityTransaction.commit();
		managerFactory.release(entityManager);
	}

	@Override
	public T findById(Object objToFind) 
	{
		T objReturn;
		entityManager = managerFactory.getEntityManager();
		objReturn = entityManager.find(getEntityClass(), objToFind);
		managerFactory.release(entityManager);
		return objReturn;
	}

	@Override
	public T update(T objToUpdate)
	{
		
		entityManager = managerFactory.getEntityManager();
		final EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		final T updatedObj = entityManager.merge(objToUpdate);
		entityTransaction.commit();
		managerFactory.release(entityManager);
		return updatedObj;
	}

	protected CriteriaBuilder getCriteriaBuilder()
	{
		return getEntityManager().getCriteriaBuilder();
	}
	
	protected CriteriaQuery<T> getCriteriaQuery()
	{
		return getCriteriaBuilder().createQuery(getEntityClass());
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.persistence.IPersistanceService#findByNamedQuery(java.lang.String)
	 */
	@Override
	public Collection<T> findByNamedQuery(String query)
	{
		final EntityManager entityManager = getEntityManager();
		try
		{
			final Query namedQuery = entityManager.createNamedQuery(query,getEntityClass());
			return namedQuery.getResultList();
		}
		finally
		{
			releaseEntityManager(entityManager);
		}
	}

	/* (non-Javadoc)
	 * @see addressbook.corebeans.persistence.IPersistanceService#findByNamedQueryAndParams(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Collection<T> findByNamedQueryAndParams(String query,Object... params)
	{
		final EntityManager entityManager = getEntityManager();
		try
		{
			final Query namedQuery = entityManager.createNamedQuery(query);
			int i =1;
			for (Object param : params)
			{
				namedQuery.setParameter(i, param);
			}
			return namedQuery.getResultList();
		}
		finally
		{
			releaseEntityManager(entityManager);
		}
	}
	

	
	
	

}
