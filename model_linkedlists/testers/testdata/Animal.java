package model_linkedlists.testers.testdata;

/*
 * Animal class
 */
public class Animal extends Generics {	
	/* fields
	 * 
	 */
	public static final String type = "Animal";
	public enum KeyType {combo, name, age, color};
	public static KeyType key = KeyType.combo;
	private String name; 
	private int age; 
	private String color;
	
	/* constructor
	 * 
	 */
	public Animal(String name, int age, String color)
	{
		this.setType(type);
		this.name = name; 
		this.age = age; 
		this.color = color; 
	}
	
	/* 
	 * toString provides output based off of this.key setting
	 */
	@Override
	public String toString()
	{
		String output="";
		switch(key) {
		case name:
			output += this.name;
			break;
		case age:
			output += "000" + this.age;
			output = output.substring(output.length()-3);
			break;
		case color:
			output += this.color;
			break;
		case combo:
		default:
			output += type + ": " + this.name  + ", " + this.color + ", " + this.age; 
		}
		return output;
		
	}
	
	/* Initialize Animal data
	 * 
	 */
	public static Generics[] animalData() {
		Generics[] ad = { 
				new Animal("Lion", 8, "Gold"),
				new Animal("Pig", 3, "Pink"),
				new Animal("Robin", 7, "Red"),
				new Animal("Cat", 10, "Black"),
				new Animal("Kitty", 1, "Calico"),
				new Animal("Dog", 14, "Brown")
		};
		return ad;
	}
	
	/* main to test Animal class
	 * 
	 */
	public static void main(String[] args)
	{
		Generics[] ad = animalData();
		for(Generics a : ad)
			System.out.println(a);
	}

}
