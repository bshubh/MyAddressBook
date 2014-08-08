/**
 * 
 */
package addressbook.vcardreader;

import java.util.List;

import addressbook.vcardprocessor.RawCardData;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface ICardReader 
{
	List<RawCardData> readCardData();
}
