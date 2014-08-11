/**
 * 
 */
package addressbook.contextobject;

import java.util.EnumMap;
import java.util.Map;

/**
 * This class will be responsible for holding and structuring the data into the correct format. 
 * 
 * @author Shubhashish Bhowmik
 *
 */
// TODO:: Change this class into the context object implementation.
public class CardContextDataObject implements ICardContextObject
{
	/** Eclipse generated serialVersionUID. */
	private static final long serialVersionUID = -7960909092077418045L;
	
	/** boolean flag for parsing the vCard 2.1.*/
	private boolean isVersion2;
	
	/** boolean flag for parsing the vCard 3.0 .*/
	private boolean isVersion3;
	
	/** boolean flag for parsing the vCard 4.0. */
	private boolean isVersion4;
	
	/** {@link Map} for holding the values of the card data.*/
	private final Map<MemberEnum, String> paramMap = new EnumMap<MemberEnum, String>(MemberEnum.class);
	
	private String rawData;
	
	/**
	 * Static factory for the class.
	 * 
	 * @return {@link CardContextDataObject}.
	 */
	public static CardContextDataObject createCardContextData()
	{
		return new CardContextDataObject();
	}
	
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
	public boolean isVersion4()
	{
		return isVersion4;
		
	}
	
	/**
	 * Set the version of the card.
	 * 
	 * @param <code>true</code> if the version of the vCard is jCard.
	 */
	public void setVersion4(boolean isVersion4)
	{
		this.isVersion4 = isVersion4;
	}

	/**
	 * @return the rawData
	 */
	public String getRawData()
	{
		return rawData;
	}

	/**
	 * @param rawData the rawData to set
	 */
	public void setRawData(String rawData)
	{
		this.rawData = rawData;
	}
	
	
}
