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
public class BeginnerAcceptor implements ICardAcceptor
{
	private final ICardContext context;
	private final ICardAcceptor nameAcceptor ;
	private final ICardAcceptor orgAcceptor;
	private final ICardAcceptor workTeleAcceptor ;
	private final ICardAcceptor homeTeleAcceptor ;
	private final ICardAcceptor orgAddressAcceptor ;
	private final ICardAcceptor homeAddressAcceptor;
	private final ICardAcceptor endCardAcceptor;
	/**
	 * @param nameVisitable
	 * @param orgVisitable
	 */
	public BeginnerAcceptor(final ICardContext context)
	{
		this.context = context;
		nameAcceptor = new NameAcceptor(context);
		orgAcceptor = new OrganizationAcceptor(context);
		workTeleAcceptor = new WorkTelephoneAcceptor(context);
		homeTeleAcceptor = new HomeTelephoneAcceptor(context);
		orgAddressAcceptor = new OrganizationAddressAcceptor(context);
		 homeAddressAcceptor = new HomeAddressAcceptor(context);
		endCardAcceptor = new EndAcceptor(context);
	}
	

	/**
	 * @return the rawCardData
	 */
	public ICardContext getRawCardData()
	{
		return context;
	}


	/* (non-Javadoc)
	 * @see addressbook.visitors.IVisitable#accept(addressbook.visitors.IVisitor)
	 */
	@Override
	public void accept(ICardVisitor visitor)
	{
		visitor.atStart(this);
		nameAcceptor.accept(visitor);
		orgAcceptor.accept(visitor);
		workTeleAcceptor.accept(visitor);
		homeTeleAcceptor.accept(visitor);
		orgAddressAcceptor.accept(visitor);
		homeAddressAcceptor.accept(visitor);
		endCardAcceptor.accept(visitor);
	}

	/**
	 * @param dataBean
	 */
	public void visitForVersion(final vCardDataBean dataBean)
	{
		dataBean.setStartvCard(true);
		dataBean.setVersion(context.getVersion().toString());
	}
}
