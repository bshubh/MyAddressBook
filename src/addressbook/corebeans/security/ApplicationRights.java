/**
 * 
 */
package addressbook.corebeans.security;

/**
 * An <code>enumeration</code> to define the CURD for the application. 
 * 
 * @author Shubhashish Bhowmik
 *
 */
public enum ApplicationRights 
{
	/** Allow creating new objects. */
	CREATE("Create"),
	
	/** Allow deleting existing objects. */
	DELETE("Delete"),
	
	
	/** Read the attributes of the entities.*/
	READ("Read"),
	
	/** Write/Edit or update the attributes of the entity.*/
	UPDATE("Update"),
	
	;
	
	private final String rightName;

	/**
	 * @param rightName
	 */
	private ApplicationRights(String rightName) 
	{
		this.rightName = rightName;
	}
	
	public String toString()
	{
		return rightName;
	}
}
