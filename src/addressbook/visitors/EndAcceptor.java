/**
 * 
 */
package addressbook.visitors;

import addressbook.applicationbeans.CardContextImpl;
import addressbook.applicationbeans.vCardDataBean;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class EndAcceptor implements IVisitable
{

	private final CardContextImpl context;
	
	
	/**
	 * @param context
	 */
	public EndAcceptor(CardContextImpl context) 
	{
		this.context = context;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(IVisitor visitor)
	{
		visitor.atEnd(this);

	}

	public void visitEnd(final vCardDataBean dataBean)
	{
		dataBean.setEndvCard(true);
		context.setDataBean(dataBean);
	}
}
