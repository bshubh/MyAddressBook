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
	
}
