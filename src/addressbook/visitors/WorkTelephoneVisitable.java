/**
 * 
 */
package addressbook.visitors;

import addressbook.contextobject.CardContextDataObject;
import addressbook.contextobject.vCardDataBean;

/**
 * TODO :: Make arrangement for multiple phone numbers. Currently it supports only one.
 * 
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class WorkTelephoneVisitable implements IVisitable 
{
	private final CardContextDataObject context;
	
	

	/** 
	 * Parameterize constructor.
	 * 
	 * @param {@link CardContextDataObject}.
	 */
	public WorkTelephoneVisitable(CardContextDataObject context)
	{
		this.context = context;
	}

	/**
	 * @return the context
	 */
	public CardContextDataObject getContext()
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
