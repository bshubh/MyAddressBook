/**
 * 
 */
package addressbook.corebeans.persistence;

import java.util.Collection;



/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IPersistanceService<T>
{
	/**
	 * @param entityToCommit defined by type <code>T</code>.
	 * @return
	 */
	boolean commit(T entityToCommit);
	
	/**
	 * @param entityToDelete, defined by the type <code>T</code>.
	 */
	void delete (T entityToDelete);
	
	/**
	 * @param objToFind as implemented {@link Object}.
	 * @return
	 */
	T findById(Object objectId);
	
	/**
	 * @param objToUpdate, defined by the type <code>T</code>.
	 * @return
	 */
	T update(T objToUpdate);
	
	/**
	 * @param query
	 * @return {@link Collection} of <code>T</code>.
	 */
	Collection<T> findByNamedQuery(String query);
	
	/**
	 * @param query
	 * @param params
	 * @return
	 */
	Collection<T> findByNamedQueryAndParams(String query, Object... params);
}
