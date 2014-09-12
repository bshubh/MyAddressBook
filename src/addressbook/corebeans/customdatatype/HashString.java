package addressbook.corebeans.customdatatype;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class HashString 
{
	private String passwordHash;


	public HashString(String password) 
	{
		this.passwordHash = Base64.encode(password.getBytes());
	}
	
	public String getString()
	{
		return passwordHash;
	}
	
	public String getPassword()
	{
		return new String(Base64.decode(passwordHash));
	}
}