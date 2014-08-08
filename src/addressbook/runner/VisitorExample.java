package addressbook.runner;

public class VisitorExample 
{
	interface HouseAcceptor
	{
		void accept(HouseVisitor visitor);
	}
	
	interface HouseVisitor
	{
		void visit(House acceptor);
		void visit(Kitchen acceptor);
		void visit(LivingRoom acceptor);
	}
	
	public class House implements HouseAcceptor
	{
	    HouseAcceptor kitchen = new Kitchen();
	    HouseAcceptor livingRoom = new LivingRoom();

	   public void accept(HouseVisitor visitor)
	    {
	        visitor.visit(this);
	        kitchen.accept(visitor);
	        livingRoom.accept(visitor);
	    }
	}

	public class Kitchen implements HouseAcceptor 
	{
	    public void accept(HouseVisitor visitor) 
	    {
	        visitor.visit(this);
	    }
	}

	public class LivingRoom implements HouseAcceptor
	{
	    public void accept(HouseVisitor visitor)
	    {
	         visitor.visit(this);
	    }
	}

	public class SpeakingHouseVisitor implements HouseVisitor 
	{
	    void visit(HouseAcceptor acceptor)
	    {
	        System.out.println("Inside a HouseAcceptor");
	    }

	    public void visit(House acceptor) {
	        System.out.println("Inside a House");
	    }

	    public void visit(Kitchen acceptor) {
	        System.out.println("Inside a Kitchen");
	    }

	    public void visit(LivingRoom acceptor) {
	        System.out.println("Inside a LivingRoom");
	    }
	}

	public static void main(String[] args) 
	{
		VisitorExample ex = new VisitorExample();
		HouseAcceptor acceptor = ex.new House();
		HouseVisitor visitor = ex.new SpeakingHouseVisitor();	
		
		// visitor.visit(acceptor); // WRONG WAY!!!
		acceptor.accept(visitor);
	}

}
