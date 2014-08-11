/**
 * 
 */
package addressbook.vcardreader;

import java.util.List;

import addressbook.contextobject.CardContextDataObject;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface ICardReader 
{
	List<CardContextDataObject> readCardData();
}
