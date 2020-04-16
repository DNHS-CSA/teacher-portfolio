package model_linkedlists.testers.testdata;

/*
 * Animal class
 */
public class Animal extends Generics {	
	/* fields
	 * 
	 */
	public enum KeyType {combo, name, age, color};
	public static final String type = "Animal";	
	public static KeyType key = KeyType.combo;
	private String aniName; 
	private int aniAge; 
	private String aniColor;
	
	/* constructor
	 * 
	 */
	public Animal(String name, int age, String color)
	{
		this.setSubType(type);
		aniName = name; 
		aniAge = age; 
		aniColor = color; 
	}
	
	/* toString override
	 * 
	 */
	@Override
	public String toString()
	{
		String output="";
		switch(key) {
		case name:
			output += this.aniName;
			break;
		case age:
			output += this.aniAge;
			break;
		case color:
			output += this.aniColor;
			break;
		case combo:
		default:
			output += "(name: " + aniName + ", age: " + aniAge + ", color: " + aniColor + ")"; 
		}
		return output;
		
	}
	
	/* Initialize Animal data
	 * 
	 */
	public static Generics[] animalData() {
		Generics[] ad = { 
				new Animal("lion", 10, "gold"),
				new Animal("pig", 10, "pink"),
				new Animal("robin", 10, "red"),
				new Animal("cat", 10, "black")
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
