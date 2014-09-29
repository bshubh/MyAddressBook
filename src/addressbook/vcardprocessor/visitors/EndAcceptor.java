/**
 * 
 */
package addressbook.vcardprocessor.visitors;

import addressbook.appbeans.ICardContext;
import addressbook.appbeans.vCardDataBean;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class EndAcceptor implements ICardAcceptor
{

	private final ICardContext context;
	
	
	/**
	 * @param context
	 */
	public EndAcceptor(ICardContext context) 
	{
		this.context = context;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(ICardVisitor visitor)
	{
		visitor.atEnd(this);

	}

	public void visitEnd(final vCardDataBean dataBean)
	{
		dataBean.setEndvCard(true);
	}
}
