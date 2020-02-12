package model_linkedlists;
// imports in test data support testing
import model_linkedlists.test_data.Alphabet;
import model_linkedlists.test_data.Animal;
import model_linkedlists.test_data.Cupcakes;

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
		System.out.println();
	}
	
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
		CircleQueueDriver trial = new CircleQueueDriver();
		
		// setup for Animals
		trial.setDataType("Animals");
		trial.addCQueue((Object[])Animal.animalData());

		// setup for Cupcakes
		trial.setDataType("Cupcakes");
		trial.addCQueue((Object[])Cupcakes.cupCakeData());
		
		// setup for Alphabet
		trial.setDataType("Alphabet");
		trial.addCQueue(Alphabet.alphabetData());

		// mixed data
		trial.setDataType("Animals then Cupcakes then Alphabet");
		trial.showCQueue();
		trial.deleteCQueue();
	}
	
}
