/**
 * 
 */
package addressbook.vcardreader;

import java.util.List;

import addressbook.appbeans.ICardContext;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface ICardReader 
{
	List<ICardContext> readCardData();
}
