/**
 * 
 */
package addressbook.visitors;

/**
 * @author Shubhashish Bhowmik
 *
 */
public interface IVisitor
{
	void visit(vCardAcceptor acceptor);
	
	void visit(NameVisitable nameVisitable);
	
	void visit(IVisitable visitable);
}
