/**
 * 
 */
package addressbook.corebeans.service;

import addressbook.applicationbeans.ICardContext;
import addressbook.corebeans.Contact;

/**
 * @author Shubhashish Bhowmik
 *
 */
public abstract class AbstractBeanCreator 
{
	
	protected final ICardContext context;
	

	/**
	 * Parameterize constructor. Must be called from the caller class.
	 * 
	 * @param context
	 */
	public AbstractBeanCreator(ICardContext context)
	{
		this.context = context;
	}


	public abstract Contact call() throws Exception; 
}
