package model_linkedlists.test_data;

public class Cupcakes {
	String frosting;
	int sprinkles;
	String flavor;
	
	Cupcakes(String frosting, int sprinkles, String flavor)
	{
		this.frosting = frosting;
		this.sprinkles = sprinkles;
		this.flavor = flavor;
		
	}
	
	public String getKey()
	{
		return flavor;
	}
	
	public int compareTo(Cupcakes c)
	{
		return flavor.compareTo(c.getKey());
	}
	
	public String toString() {
		String all = this.flavor + ", " + this.sprinkles + ", " + this.frosting;
		return (all);
	}
	
	public static Cupcakes[] cupCakeData() {
		Cupcakes[] cc = { 
				new Cupcakes("Red", 4, "Red Velvet"),
			    new Cupcakes("Orange", 5, "Orange"),
			    new Cupcakes("Yellow", 6, "Lemon"),
			    new Cupcakes("Green", 7, "Apple"),
			    new Cupcakes("Blue", 8, "Blueberry"),
			    new Cupcakes("Purple", 9, "Blackberry"),
			    new Cupcakes("Pink", 10, "Strawberry"),
			    new Cupcakes("Tan", 11, "Vanilla"),
			    new Cupcakes("Brown", 12, "Chocolate"),
		};
		return cc;
	}
	
	public static void main(String[] args)
	{
		Cupcakes[] cc = cupCakeData();
		for(int i = 0; i < cc.length; i++)
			System.out.println(cc[i]);
	}
	
}
