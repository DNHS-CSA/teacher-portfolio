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
	private int count;

	public CircleQueueDriver()
	{
		count = 0;		
		cqueue = new CircleQueue();
	}

	public void addCQueue(Object[] objects)
	{
		System.out.println("Add " + objects.length);
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
	
	/* 
	 * Illustrate different Objects that can be placed on same Queue
	 */
	public void deleteCQueue()
	{
		int length = this.count;
		System.out.println("Delete " + length);
		
		for (int i = 0; i<length; i++)
		{
			System.out.println("Delete: " + cqueue.delete() + " " + cqueue);
			this.count--;
		}
	}
	
	
	/* 
	 * Illustrate different Objects that can be placed on same Queue
	 */
	public static void main(String[] args)
	
	{	
		
		//queue
		CircleQueueDriver trial = new CircleQueueDriver();
		
		//add different types of objects to the same opaque queue
		trial.addCQueue(Animal.animalData());
		trial.addCQueue(Cupcakes.cupCakeData());
		trial.addCQueue(Alphabet.alphabetData());		
		//display queue objects in queue order
		trial.showCQueue();
		
		//sort queue objects by specific element within the object and display in sort order
		Animal.key = Animal.KeyType.name;
		Cupcakes.key = Cupcakes.KeyType.flavor;
		Alphabet.key = Alphabet.KeyType.letter;
		trial.cqueue.insertionSort();
		trial.showCQueue();
		
		//display queue objects
		Animal.key = Animal.KeyType.combo;
		Cupcakes.key = Cupcakes.KeyType.combo;
		Alphabet.key = Alphabet.KeyType.combo;
		trial.showCQueue();
		
		//delete queue objects
		trial.deleteCQueue();
	}
	
}
