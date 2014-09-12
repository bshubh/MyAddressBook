/**
 * 
 */
package addressbook.corebeans.service;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IPersistanceService<T>
{
	/**
	 * @param Object
	 * @return
	 */
	boolean commit(T entityToCommit);
	
	/**
	 * @param entityToDelete
	 */
	void delete (T entityToDelete);
	
	/**
	 * @param id
	 * @return
	 */
	T find(Object objToFind);
	
	/**
	 * @param objToUpdate
	 * @return
	 */
	T update(T objToUpdate);
}
