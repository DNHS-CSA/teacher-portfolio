package model_linkedlists.test_data;

/*
 * Animal class
 */
public class Animal {
	
	/* fields
	 * 
	 */
	private String aniName; 
	private int aniAge; 
	private String aniColor;
	
	/* constructor
	 * 
	 */
	public Animal(String name, int age, String color)
	{
		aniName = name; 
		aniAge = age; 
		aniColor = color; 
	}
	
	/* key value
	 * 
	 */
	public String getKey()
	{
		return aniName;
	}
	
	/* compareTo override
	 * 
	 */
	public int compareTo(Animal a)
	{
		return aniName.compareTo(a.getKey());
	}
	
	/* toString override
	 * 
	 */
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
