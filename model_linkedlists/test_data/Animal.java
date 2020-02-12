package model_linkedlists.test_data;

public class Animal {
	
	private String aniName; 
	private int aniAge; 
	private String aniColor;
	
	public Animal(String name, int age, String color)
	{
		aniName = name; 
		aniAge = age; 
		aniColor = color; 
	}
	
	public String toString()
	{
		return "(name: " + aniName + ", age: " + aniAge + ", color: " + aniColor + ")"; 
	}
	
	/* Initialize Animal data
	 * 
	 */
	public static Animal[] animalData() {
		Animal[] ad = { 
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
		Animal[] ad = animalData();
		for(Animal a : ad)
			System.out.println(a);
	}

}
