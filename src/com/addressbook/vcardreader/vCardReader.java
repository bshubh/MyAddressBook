/**
 * 
 */
package com.addressbook.vcardreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;

import com.addressbook.vcardprocessor.RawCardData;

/**
 * This class is responsible for processing & reading the content from the vCard file.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class vCardReader
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
	 * @return {@link LinkedList} representation of the {@link RawCardData}.
	 */
	public LinkedList<RawCardData> readCardData() 
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
	 * @param rawdata as {@link String}.
	 * @return {@link LinkedList} of {@link RawCardData}.
	 */
	private LinkedList<RawCardData> processData(String rawdata) 
	{
		final LinkedList<RawCardData> cardDataList = new LinkedList<RawCardData>();
		final StringBuilder rawData = new StringBuilder();
		
		final String[] tokens = rawdata.split("\\n");
		
		boolean startCard = false, endCard = false;
		
		for(String token : tokens)
		{
			final RawCardData rawCardData  = new RawCardData();
			if (token.startsWith(vCardBEGIN))
			{
				startCard = true;
			}
			else if(token.startsWith(vCardEND))
			{
				startCard = endCard;
				endCard = true;
			}
			else if( token.startsWith(VERSION))
			{
				final String versionValue = token.substring(token.indexOf(":") +1);
				if(versionValue.equalsIgnoreCase("2.1"))
				{
					rawCardData.setVersion2(true);
				}
				else if(versionValue.equalsIgnoreCase("3.0"))
				{
					rawCardData.setVersion3(true);
				}
			}
			else
			{
				rawData.append(token);
			}
			
			if(endCard)
			{
				rawCardData.setRawData(rawData.toString());
				cardDataList.add(rawCardData);
				endCard = false;
				startCard = false;
				
			}
			System.out.println("\t "+token);
		}
		
		return cardDataList;
		
	}

	
	public static void main(String[] args) 
	{
		vCardReader reader = new vCardReader("PIM00005.vcf");
		reader.readCardData();
	}
}
