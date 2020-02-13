package model_linkedlists.testers.testdata;

/*
 * Animal class
 */
public class Animal extends Generics {	
	/* fields
	 * 
	 */
	public static final String type = "Animal";	
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
	
	/* identifier of Class Type
	 * 
	 */
	@Override
	public String getType()
	{
		return type;
	}
	
	/* key value
	 * 
	 */
	@Override
	public String getKey()
	{
		return aniName;
	}
	
	/* compareTo override
	 * 
	 */
	@Override
	public int compareTo(Object o)
	{
		return aniName.compareTo(((Animal) o).getKey());
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
