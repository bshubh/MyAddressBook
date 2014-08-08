/**
 * 
 */
package addressbook.visitors;

import addressbook.vcardprocessor.RawCardData;
import addressbook.vcardprocessor.vCardDataBean;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class vCardVisitor implements IVisitor
{

	private final vCardDataBean dataBean;

	/**
	 * Parameterize constructor.
	 * 
	 * @param rawCardData
	 */
	public vCardVisitor()
	{
		this.dataBean = new vCardDataBean();
	}

	
	/**
	 * @return the dataBean
	 */
	public vCardDataBean getDataBean()
	{
		return dataBean;
	}


	@Override
	public void visit(vCardAcceptor acceptor)
	{
		//acceptor.accept(this);
		RawCardData cardData = acceptor.getRawCardData();
		if (cardData.isVersion2())
		{
			dataBean.setVersion("2.1");
		}
		else if (cardData.isVersion3())
		{
			dataBean.setVersion("3.0");
		}
		else if (cardData.isVersion4())
		{
			dataBean.setVersion("4.0");
		}
			
		
	}


	@Override
	public void visit(NameVisitable nameVisitable) 
	{
		nameVisitable.accept(this);
		parseForNames(nameVisitable.getRawCardData());
	}


	@Override
	public void visit(IVisitable visitable) 
	{
		
	}

	private void parseForNames(final RawCardData rawCardData)
	{
		final String[] tokens = rawCardData.getRawData().split("\\n");
		
		String firstName = "", lastname = "" , middlename = "";
		for (String token : tokens) 
		{
			if(token.startsWith("N"))
			{
				firstName = token.substring(token.indexOf(":")+1,token.indexOf(";")-1);
				lastname = token.substring(token.lastIndexOf(";"));
				middlename = token.substring(token.indexOf(";")+1, token.lastIndexOf(";")-1);
				break;
			}
		}
		dataBean.setFirstName(firstName);
		dataBean.setLastName(lastname);
		dataBean.setMiddleName(middlename);
		
		
	}
}
