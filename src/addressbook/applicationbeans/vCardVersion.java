/**
 * 
 */
package addressbook.applicationbeans;

/**
 * Contains all the supported version of the vCard.
 * 
 * @author Shubhashish Bhowmik
 *
 */
public enum vCardVersion 
{
	v2_1("VERSION:2.1"),
	v3_0("VERSION:3.0"),
	v4_0("VERSION:4.0"),
	jCard("[\"version\", {}, \"text\", \"4.0\"]"),
	xCard("urn:ietf:params:xml:ns:vcard-4.0"),
	hCard1_0("html"),
	UnDefined("Undefined")
	;
	
	private String versionName;
	
	private vCardVersion(String vName)
	{
		versionName = vName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return versionName;
	}
	
}
