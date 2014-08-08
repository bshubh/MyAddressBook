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
	void accept(IVisitor visitor);
}
