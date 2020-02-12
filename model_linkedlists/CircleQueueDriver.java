package model_linkedlists;
import model_linkedlists.testers.Alphabet;
import model_linkedlists.testers.Animal;
import model_linkedlists.testers.Cupcakes;

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

	public void addCQueue(Object[] ob)
	{
		System.out.println("Add " + dataType);
		for (Object o : ob)
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
