package model_linkedlists;
import model_linkedlists.testers.Animal;
import model_linkedlists.testers.Cupcakes;

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

	public void pushStack(Object[] ob)
	{
		System.out.println("Add " + dataType);
		for (Object o : ob)
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
	
	public static void main(String[] args)
	
	{
		StackDriver trial = new StackDriver();
		
		// setup for Animals
		trial.setDataType("Animals");
		trial.pushStack((Object[])Animal.animalData());

		// setup for Cupcakes
		trial.setDataType("Cupcakes");
		trial.pushStack((Object[])Cupcakes.cupCakeData());

		// mixed stack
		trial.setDataType("Cupcakes then Animals");
		trial.showStack();
		trial.popStack();
	}

}
