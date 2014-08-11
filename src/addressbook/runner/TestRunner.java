/**
 * 
 */
package addressbook.runner;

import java.util.List;

import addressbook.contextobject.CardContextDataObject;
import addressbook.vcardprocessor.CardProcessorVersion2;
import addressbook.vcardprocessor.CardProcessorVersion3;
import addressbook.vcardprocessor.CardProcessorVersion4;
import addressbook.vcardprocessor.IvCardProcessor;
import addressbook.vcardreader.ICardReader;
import addressbook.vcardreader.vCardReader;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class TestRunner 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			final IvCardProcessor version4Processor = new CardProcessorVersion4(); // last processor, as of now. 
			final IvCardProcessor version3Processor = new CardProcessorVersion3(version4Processor); // last processor, as of now. 
			final IvCardProcessor version2Processor = new CardProcessorVersion2(version3Processor); // last processor, as of now.
			
			
			final ICardReader reader = new vCardReader("PIM00005.vcf");
			final List<CardContextDataObject> cardDataList = reader.readCardData();
			
			for (CardContextDataObject rawCardData : cardDataList)
			{
				version2Processor.parseCardData(rawCardData);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
