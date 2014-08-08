/**
 * 
 */
package addressbook.runner;

import java.util.List;

import addressbook.vcardprocessor.CardProcessorVersion2;
import addressbook.vcardprocessor.CardProcessorVersion3;
import addressbook.vcardprocessor.CardProcessorVersion4;
import addressbook.vcardprocessor.IvCardProcessor;
import addressbook.vcardprocessor.RawCardData;
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
			final IvCardProcessor version2Processor = new CardProcessorVersion2();
			final IvCardProcessor version3Processor = new CardProcessorVersion3();
			final IvCardProcessor version4Processor = new CardProcessorVersion4();
			
			final ICardReader reader = new vCardReader("PIM00005.vcf");
			final List<RawCardData> cardDataList = reader.readCardData();
			
			for (RawCardData rawCardData : cardDataList)
			{
				version2Processor.forwardToNextLevel(version3Processor);
				version2Processor.process(rawCardData);
				version3Processor.forwardToNextLevel(version4Processor);
				version3Processor.process(rawCardData);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
