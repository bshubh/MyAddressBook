/**
 * 
 */
package com.addressbook.vcardprocessor;

/**
 * This class will be responsible for holding and structuring the data into the correct format. 
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class RawCardData
{
	private boolean isVersion2;
	private boolean isVersion3;
	private boolean isjCard;
	private String rawData;
	
	/**
	 * @return <code>true</code> if the version of the vCard is 2.1 
	 */
	public boolean isVersion2()
	{
		return isVersion2;
	}
	
	/**
	 * Set the version of vCard
	 * 
	 * @param <code>true</code> if the version of the vCard is 2.1 
	 */
	public void setVersion2(boolean isVersion2) 
	{
		this.isVersion2 = isVersion2;
	}
	
	/**
	 * @return <code>true</code> if the version of the vCard is 3.0.
	 */
	public boolean isVersion3()
	{
		return isVersion3;
	}
	
	/**
	 * Set the version of vCard
	 * @param <code>true</code> if the version of the vCard is 3.0
	 */
	public void setVersion3(boolean isVersion3) 
	{
		this.isVersion3 = isVersion3;
	}
	
	
	/**
	 * @return <code> true</code> if the version of the vCard is jCard.
	 */
	public boolean isjCard()
	{
		return isjCard;
		
	}
	
	/**
	 * Set the version of the card.
	 * 
	 * @param <code>true</code> if the version of the vCard is jCard.
	 */
	public void setIsjCard(boolean isjCard)
	{
		this.isjCard = isjCard;
	}

	/**
	 * @return get the raw data as {@link String}.
	 */
	public String getRawData()
	{
		return rawData;
	}

	/**
	 * Using this setter, set the raw data into this bean.
	 * This raw data will be used to process further in order to retrieve all the neccessary information.
	 * 
	 * @param rawData, as {@link String}.
	 */
	public void setRawData(String rawData)
	{
		this.rawData = rawData;
	}
	
	
	
}
