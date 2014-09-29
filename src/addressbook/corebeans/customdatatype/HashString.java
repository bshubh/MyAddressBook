package addressbook.corebeans.customdatatype;


import javax.persistence.Embeddable;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author Shubhashish Bhowmik
 *
 */
@Embeddable
public class HashString 
{
	private String passwordHash;


	public HashString(String password) 
	{
		this.passwordHash = Base64.encode(password.getBytes());
	}
	
	public String getPassword()
	{
		return new String(Base64.decode(passwordHash));
	}
	
	public String toString()
	{
		return passwordHash;
	}
}