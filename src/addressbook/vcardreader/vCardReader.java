/**
 * 
 */
package addressbook.vcardreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;

import addressbook.applicationbeans.CardContextImpl;

/**
 * This class is responsible for processing & reading the content from the vCard file.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class vCardReader implements ICardReader
{
	private final static int ALLOCATE_CAPACITY = 10;
	private static final String vCardBEGIN = "BEGIN";
	private static final String vCardEND = "END";
	private static final String VERSION ="VERSION";
	
	private final String fileName;

	/**
	 * Constructor with filename to read
	 * 
	 * @param fileName, full path of the file to read as {@link String}
	 */
	public vCardReader(String fileName)
	{
		this.fileName = fileName;
	}
	
	/**
	 * @return {@link LinkedList} representation of the {@link CardContextImpl}.
	 */
	public List<CardContextImpl> readCardData() 
	{
		FileInputStream inStream = null;
		final StringBuilder strBuilder = new StringBuilder(ALLOCATE_CAPACITY);
		final ByteBuffer byteBuffer = ByteBuffer.allocate(ALLOCATE_CAPACITY);
		try
		{
			inStream = new FileInputStream(this.fileName);
			final FileChannel fileChannel = inStream.getChannel();
			
			while( ( fileChannel.read(byteBuffer)) != -1)
			{
				byteBuffer.flip();
				strBuilder.append(new String(byteBuffer.array()));
				byteBuffer.clear();
			}
			
			//System.out.println("vCardReader.readCardData(): "+ strBuilder.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (inStream != null ) 
				{
					inStream.close();
				}
			}
			catch(IOException ignore)
			{}
		}
		
		return processData(strBuilder.toString());
	}
	
	/**
	 * This method will be responsible for processing the retrieved raw data from vCard.
	 * It will check explicitly the version of the processing vCard.
	 * 
	 * TODO:: Make this parsing event based.
	 * 
	 * @param rawdata as {@link String}.
	 * @return {@link LinkedList} of {@link CardContextImpl}.
	 */
	private synchronized LinkedList<CardContextImpl> processData(String rawdata) 
	{
		final LinkedList<CardContextImpl> cardDataList = new LinkedList<CardContextImpl>();
		final StringBuilder rawDataBuilder = new StringBuilder();
		
		final String[] tokens = rawdata.split("\\n");
		
		boolean startCard = false, endCard = false, version2 = false, version3 = false, version4 = false;
		
		for(String token : tokens)
		{
			 
			if (token.startsWith(vCardBEGIN))
			{
				startCard = true;
				rawDataBuilder.delete(0, rawDataBuilder.capacity());
			}
			else if(token.startsWith(vCardEND))
			{
				startCard = endCard;
				endCard = true;
			}
			else if( token.startsWith(VERSION))
			{
				final String versionValue = token.substring(token.indexOf(":") +1).replaceAll("(\\r|\\n)", "");
				if(versionValue.equalsIgnoreCase("2.1"))
				{
					version2 = true;
				}
				else if(versionValue.equalsIgnoreCase("3.0"))
				{
					version3 = true;
				}
				else if (versionValue.equalsIgnoreCase("4.0"))
				{
					version4 = true;
				}
			}
			else
			{
				rawDataBuilder.append(token);
			}
			
			if(endCard)
			{
				final CardContextImpl rawCardData = CardContextImpl.createCardContextData();
				rawCardData.setRawData(rawDataBuilder.toString());
				rawCardData.setVersion2(version2);
				rawCardData.setVersion3(version3);
				rawCardData.setVersion4(version4);
				
				cardDataList.add(rawCardData);
				endCard = false;
				startCard = false;
				version2 = false;
				version3 = false;
				version4 = false;
				
			}
		}
		
		return cardDataList;
		
	}
	
}
