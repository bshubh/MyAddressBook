/**
 * 
 */
package addressbook.vcardprocessor.visitors;


/**
 * @author Shubhashish Bhowmik
 *
 */
public interface ICardAcceptor
{
	/**
	 * @param visitor
	 */
	void accept(ICardVisitor visitor);
	
}