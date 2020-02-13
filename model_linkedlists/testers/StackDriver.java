package model_linkedlists.testers;

import model_linkedlists.Stack;
import model_linkedlists.testers.testdata.Alphabet;
import model_linkedlists.testers.testdata.Animal;
import model_linkedlists.testers.testdata.Cupcakes;

/**
 * Stack Driver takes a list of Objects and puts them onto the Stack
 * @author johnmortensen
 *
 */
public class StackDriver {
	
	private Stack stack;
	private String dataType="";
	private int count;

	public StackDriver()
	{
		count = 0;		
		stack = new Stack();
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void pushStack(Object[] objects)
	{
		System.out.println("Add " + dataType);
		for (Object o : objects)
		{
			stack.push(o);
			System.out.println("Push: " + stack.getObject() + " " + stack);
			this.count++;
		}
		System.out.println();
			
	}
	
	public void showStack()
	{
		System.out.println("Size: " + count);
		System.out.println("Top Element: " + stack.getObject());
		System.out.println("Full Stack: " + stack);
		System.out.println();
	}
	
	public void popStack()
	{
		System.out.println("Delete " + dataType);
		for (int x = 0; x<count; x++)
		{
			System.out.println("Pop: " + stack.pop() + " " + stack);
		}
	}
	
	/* 
	 * Illustrate different Objects that can be placed on same Stack
	 */
	public static void main(String[] args)
	{
		StackDriver trial = new StackDriver();
		
		// setup for Animals
		trial.setDataType("Animals");
		trial.pushStack(Animal.animalData());

		// setup for Cupcakes
		trial.setDataType("Cupcakes");
		trial.pushStack(Cupcakes.cupCakeData());
		
		// setup for Alphabet
		trial.setDataType("Alphabet");
		trial.pushStack(Alphabet.alphabetData());

		// mixed stack
		trial.setDataType("Alphabet then Cupcakes then Animals");
		trial.showStack();
		trial.popStack();
	}

}
