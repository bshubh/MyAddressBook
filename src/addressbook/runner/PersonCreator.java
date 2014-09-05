/**
 * 
 */
package addressbook.runner;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import addressbook.applicationbeans.ICardContext;
import addressbook.applicationbeans.vCardDataBean;
import addressbook.corebeans.Person;

/**
 * @author Shubhashish Bhowmik
 *
 */
public class PersonCreator implements Future<Person>
{
	private final ICardContext context;

	/**
	 * @param context
	 */
	public PersonCreator(ICardContext context) 
	{
		this.context = context;
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning)
	{
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isCancelled()
	{
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isDone()
	{
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Person get() throws InterruptedException, ExecutionException {
		final vCardDataBean databean = context.getDataBean();
		final Person person = new Person(databean.getFirstName(), databean.getMiddleName(), databean.getLastName());
		
		return person;
	}



	@Override
	public Person get(long timeout, TimeUnit unit) throws InterruptedException,	ExecutionException, TimeoutException 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
