/**
 * 
 */
package addressbook.vcardreader;

import java.util.List;

import addressbook.applicationbeans.CardContextImpl;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface ICardReader 
{
	List<CardContextImpl> readCardData();
}
