/**
 * 
 */
package addressbook.applicationbeans;

import java.io.Serializable;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface ICardContext extends Serializable 
{
	/**
	 * @return {@link vCardDataBean}
	 */
	vCardDataBean getDataBean();
	
	/**
	 * @return {@link vCardVersion}
	 */
	vCardVersion getVersion();
	
	/**
	 * @param rawData
	 */
	void setRawData(String rawData);
	
	/**
	 * @param cardVersion
	 */
	void setCardVersion(vCardVersion cardVersion);
	
	/**
	 * @return
	 */
	String getRawData();
}
