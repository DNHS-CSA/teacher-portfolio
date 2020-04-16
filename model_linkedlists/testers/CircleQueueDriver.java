package model_linkedlists.testers;
import model_linkedlists.CircleQueue;
import model_linkedlists.testers.testdata.*;

/**
 * Circle Queue Driver takes a list of Objects and puts them onto the Queue
 * @author johnmortensen
 *
 */
public class CircleQueueDriver {
	
	private CircleQueue cqueue;
	private String dataType="";
	private int count;

	public CircleQueueDriver()
	{
		count = 0;		
		cqueue = new CircleQueue();
	}
	
	protected void setCount(int count) {
		this.count = count;
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void addCQueue(Object[] objects)
	{
		System.out.println("Add " + dataType);
		for (Object o : objects)
		{
			cqueue.add(o);
			System.out.println("Add: " + cqueue.getObject() + " " + cqueue);
			this.count++;
		}
		System.out.println();			
	}
	
	
	public void showCQueue()
	{
		System.out.println("Size: " + count);
		System.out.println("First Element: " + cqueue.getFirstObject());
		System.out.println("Last Element: " + cqueue.getLastObject());
		System.out.println("Full cqueue: " + cqueue);
		
		/* To compare objects you need to have a Type of class
		 * Generic is abstract but this code does not allow mixed base
		 */
		System.out.println("Compare adjacent objects " + dataType);
		Object c = cqueue.getFirstObject();
		for (int i = 0; c != null && i < count; i++)
		{
			cqueue.setNext();
			Object n = cqueue.getObject();
			
			if (c != null && n != null) {
				System.out.println( c + " compare to " + n );
				System.out.println(( c.toString().compareTo(n.toString()) ));

			}
			c = n;
			
		}
		System.out.println();
	}
	
	/* 
	 * Illustrate different Objects that can be placed on same Queue
	 */
	public void deleteCQueue()
	{
		System.out.println("Delete " + dataType);
		for (int x = 0; x<count; x++)
		{
			System.out.println("Delete: " + cqueue.delete() + " " + cqueue);		
		}
	}
	
	
	/* 
	 * Illustrate different Objects that can be placed on same Queue
	 */
	public static void main(String[] args)
	
	{	
		
		// general queue
		CircleQueueDriver trial = new CircleQueueDriver();
		
		// setup for Animals
		trial.setCount(0);
		trial.setDataType(Animal.type);
		trial.addCQueue(Animal.animalData());
		Animal.key = Animal.KeyType.name;
		trial.showCQueue();
		trial.cqueue.sort();
		trial.showCQueue();
		trial.deleteCQueue();
		
		// setup for Cupcakes
		//trial.setCount(0);
		//trial.setDataType(Cupcakes.type);
		//trial.addCQueue(Cupcakes.cupCakeData());
		//trial.showCQueue();
		//trial.deleteCQueue();
		
		// setup for Alphabet
		//trial.setCount(0);
		//trial.setDataType(Alphabet.type);
		//trial.addCQueue(Alphabet.alphabetData());
		//trial.showCQueue();
		//trial.deleteCQueue();
		
		// mixed queue
		//trial.setCount(0);
		//trial.setDataType(Generics.type);
		//trial.addCQueue(Animal.animalData());
		//trial.addCQueue(Cupcakes.cupCakeData());		// Why do these fail?
		//trial.addCQueue(Alphabet.alphabetData());
		//trial.showCQueue();
		//trial.deleteCQueue();
	}
	
}
