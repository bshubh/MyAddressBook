/**
 * 
 */
package addressbook.vcardprocessor;

/**
 * Normal data bean to contain the information after processing the {@link RawCardData}.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public class vCardDataBean 
{
	private String firstName;
	private String middleName;
	private String lastName;
	private String version;
	
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
		buildToString.append("END:VCARD");
		
		return buildToString.toString();
	}

	
	
}
