/**
 * 
 */
package addressbook.applicationbeans;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

/**
 * This class will be responsible for holding and structuring the data into the correct format. 
 * 
 * @author Shubhashish Bhowmik
 *
 */
// TODO:: Change this class into the context object implementation.
/**
 * @author Shubhashish Bhowmik
 *
 */
public class CardContextImpl implements ICardContext
{
	/** Eclipse generated serialVersionUID. */
	private static final long serialVersionUID = -7960909092077418045L;
	
	/** Unique identifier of the context object.*/
	private final UUID identifier;
	
	/** Card version, as defined in the vCard.*/
	private vCardVersion cardVersion;
	
	/** {@link Map} for holding the values of the card data.*/
	private final Map<MemberEnum, String> paramMap = new EnumMap<MemberEnum, String>(MemberEnum.class);
	
	
	/** Raw {@link String} data after reading from the vCard.*/
	private String rawData;
	
	/** {@link vCardDataBean} representation of vCard.*/
	private final vCardDataBean dataBean;
	
	/**
	 * @param identifier
	 */
	public CardContextImpl()
	{
		this.identifier = UUID.randomUUID();
		dataBean = new vCardDataBean();
	}

	/**
	 * Static factory for the class.
	 * 
	 * @return {@link CardContextImpl}.
	 */
	public static CardContextImpl createCardContextData()
	{
		return new CardContextImpl();
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

	/**
	 * @return the dataBean
	 */
	public vCardDataBean getDataBean() 
	{
		return dataBean;
	}


	@Override
	public vCardVersion getVersion() 
	{
		return cardVersion;
	}

	@Override
	public void setCardVersion(vCardVersion cardVersion)
	{
		this.cardVersion = cardVersion;
		
	}

	
	
	
}
