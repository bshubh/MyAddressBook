/**
 * 
 */
package addressbook.visitors;

import addressbook.applicationbeans.CardContextImpl;
import addressbook.applicationbeans.vCardDataBean;

/**
 * TODO :: Make arrangement for multiple phone numbers. Currently it supports only one.
 * 
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class WorkTelephoneVisitable implements IVisitable 
{
	private final CardContextImpl context;
	
	

	/** 
	 * Parameterize constructor.
	 * 
	 * @param {@link CardContextImpl}.
	 */
	public WorkTelephoneVisitable(CardContextImpl context)
	{
		this.context = context;
	}

	/**
	 * @return the context
	 */
	public CardContextImpl getContext()
	{
		return context;
	}

	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor)
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
