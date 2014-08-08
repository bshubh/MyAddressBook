/**
 * 
 */
package addressbook.vcardprocessor;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IInterpretor<T> 
{
	T interpret(RawCardData cardData);
}
