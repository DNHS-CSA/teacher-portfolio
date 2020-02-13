package model_linkedlists.test_data;
import java.util.ArrayList;
import util.ConsoleMethods;

public class Alphabet extends Generics {
		
	private char letter;
	private static final int size = 26;
	
	public Alphabet(char l)
	{
		this.letter = l;
	}
	
	@Override
	public String getKey()
	{
		return String.valueOf(letter);
	}
	
	@Override
	public int compareTo(Object o)
	{
		return getKey().compareTo(((Alphabet) o).getKey());
	}
	
	public String toString()
	{
		return ("" + letter); 
	}
	
	public static Generics[] alphabetData() 
	{	
		Generics[] alphabet = new Alphabet[Alphabet.size];
		for (int i = 0; i < Alphabet.size; i++)
		{
			alphabet[i] = new Alphabet( (char)('a' + i) );
		} 	
		return alphabet;
	}
	
	/* main to test Animal class
	 * 
	 */
	public static void main(String[] args)
	{
		Generics[] ad = alphabetData();
		for(Generics a : ad)
			ConsoleMethods.print("" + a);
	}
	
}
		
	
	