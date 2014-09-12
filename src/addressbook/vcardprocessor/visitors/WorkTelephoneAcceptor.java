/**
 * 
 */
package addressbook.vcardprocessor.visitors;

import addressbook.applicationbeans.CardContextImpl;
import addressbook.applicationbeans.ICardContext;
import addressbook.applicationbeans.vCardDataBean;

/**
 * TODO :: Make arrangement for multiple phone numbers. Currently it supports only one.
 * 
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class WorkTelephoneAcceptor implements ICardAcceptor 
{
	private final ICardContext context;
	
	

	/** 
	 * Parameterize constructor.
	 * 
	 * @param {@link CardContextImpl}.
	 */
	public WorkTelephoneAcceptor(ICardContext context)
	{
		this.context = context;
	}

	/**
	 * @return the context
	 */
	public ICardContext getContext()
	{
		return context;
	}

	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(ICardVisitor visitor)
	{
		visitor.atWorkTelephone(this);
	}
	
	/**
	 * @param dataBean
	 */
	public void visitForWorkTelephone(final vCardDataBean dataBean)
	{
		final String newLine = new String("\\r");
		final String[] tokens = context.getRawData().split(newLine);
		
		String telWork = "";
		for (String token : tokens) 
		{
			if(token.startsWith("TEL;WORK"))
			{
				telWork = token.substring(token.indexOf(":")+1);
				break;
			}
		}
		
		dataBean.setWorkTelephoneNr(telWork);
	}

}
