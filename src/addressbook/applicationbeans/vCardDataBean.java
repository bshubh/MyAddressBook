/**
 * 
 */
package addressbook.applicationbeans;

import java.io.Serializable;


/**
 * Normal data bean to contain the information after processing the {@link CardContextImpl}.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class vCardDataBean implements Serializable
{
	/** Eclispe generated serialVersionUID. */
	private static final long serialVersionUID = 7865264407889273058L;
	
	private boolean startvCard;
	private boolean endvCard;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String version;
	private String organizationName;
	private String title;
	private String workTelephoneNr;
	private String homeTelephoneNr;
	private String workAddress;
	private String homeAddress;
	private String emailAddress;
	private String nickName;
	
	/**
	 * Default constructor
	 * 
	 */
	public vCardDataBean() 
	{
		
	}

	/**
	 * @return the firstname as {@link String}.
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Set the firstname.
	 * 
	 * @param firstName as {@link String}.
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return middlename as {@link String}.
	 */
	public String getMiddleName() 
	{
		return middleName;
	}

	/**
	 * Set the middle name.
	 * 
	 * @param middleName as {@link String}.
	 */
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	/**
	 * @return last name as {@link String}.
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Set the last name.
	 * 
	 * @param lastName as {@link String}.
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	/**
	 * @return the {@link String} representation of the name of the person.
	 */
	public String getFullName()
	{
		final StringBuilder nameBuilder = new StringBuilder(10);
		nameBuilder.append(lastName +",");
		if(getMiddleName() != null && !getMiddleName().isEmpty())
			nameBuilder.append(middleName);
		nameBuilder.append(firstName);
		
		
		return nameBuilder.toString();
	}
	
	/**
	 * @return the startvCard
	 */
	public boolean isStartvCard()
	{
		return startvCard;
	}

	/**
	 * @param startvCard the startvCard to set
	 */
	public void setStartvCard(boolean startvCard) 
	{
		this.startvCard = startvCard;
	}

	/**
	 * @return the endvCard
	 */
	public boolean isEndvCard()
	{
		return endvCard;
	}

	/**
	 * @param endvCard the endvCard to set
	 */
	public void setEndvCard(boolean endvCard)
	{
		this.endvCard = endvCard;
	}

	/**
	 * @return the version
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) 
	{
		this.version = version;
	}

	
	
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName()
	{
		return organizationName;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) 
	{
		this.organizationName = organizationName;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) 
	{
		this.title = title;
	}

	
	
	/**
	 * @return the workTelephoneNr
	 */
	public String getWorkTelephoneNr() 
	{
		return workTelephoneNr;
	}

	/**
	 * @param workTelephoneNr the workTelephoneNr to set
	 */
	public void setWorkTelephoneNr(String workTelephoneNr)
	{
		this.workTelephoneNr = workTelephoneNr;
	}

	
	
	/**
	 * @return the homeTelephoneNr
	 */
	public String getHomeTelephoneNr() 
	{
		return homeTelephoneNr;
	}

	/**
	 * @param homeTelephoneNr the homeTelephoneNr to set
	 */
	public void setHomeTelephoneNr(String homeTelephoneNr)
	{
		this.homeTelephoneNr = homeTelephoneNr;
	}

	
	
	/**
	 * @return the workAddress
	 */
	public String getWorkAddress() 
	{
		return workAddress;
	}

	/**
	 * @param workAddress the workAddress to set
	 */
	public void setWorkAddress(String workAddress)
	{
		this.workAddress = workAddress;
	}

	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress()
	{
		return homeAddress;
	}

	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) 
	{
		this.homeAddress = homeAddress;
	}
	
	

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	
	
	/**
	 * @return the nickName
	 */
	public String getNickName() 
	{
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder buildToString = new StringBuilder(10);
		buildToString.append("BEGIN:VCARD");
		buildToString.append("\n");
		buildToString.append("VERSION:"+version);
		buildToString.append("\n");
		buildToString.append("N:");
		buildToString.append(firstName+";");
		if(middleName != null && !middleName.isEmpty())
		{
			buildToString.append(middleName+";");
		}
		buildToString.append(lastName);
		buildToString.append("\n");
		buildToString.append("FN:"+getFullName());
		buildToString.append("\n");
		buildToString.append("ORG:"+getOrganizationName());
		buildToString.append("\n");
		buildToString.append("TITLE:"+getTitle());
		buildToString.append("\n");
		buildToString.append("TEL;WORK;VOICE:"+getWorkTelephoneNr());
		buildToString.append("\n");
		buildToString.append("TEL;HOME;VOICE:"+getHomeTelephoneNr());
		buildToString.append("\n");
		buildToString.append("ADR;WORK:"+getWorkAddress());
		buildToString.append("\n");
		buildToString.append("ADR;HOME:"+getHomeAddress());
		buildToString.append("\n");
		buildToString.append("EMAIL;PREF;INTERNET:"+getHomeAddress());
		buildToString.append("\n");
		buildToString.append("END:VCARD");
		
		return buildToString.toString();
	}

	
	
}
