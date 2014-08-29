/**
 * 
 */
package addressbook.visitors;


/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IVisitable
{
	/**
	 * @param visitor
	 */
	void accept(IVisitor visitor);
	
}