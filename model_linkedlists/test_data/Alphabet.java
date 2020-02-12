package model_linkedlists.test_data;
import java.util.ArrayList;
import util.ConsoleMethods;

public class Alphabet {
		
	private char letter;
	private static final int size = 26;
	
	public Alphabet(char l)
	{
		this.letter = l;
	}
	
	public String toString()
	{
		return ("" + letter); 
	}
	
	public static Alphabet[] alphabetData() 
	{	
		Alphabet[] alphabet = new Alphabet[Alphabet.size];
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
		Alphabet[] ad = alphabetData();
		for(Alphabet a : ad)
			ConsoleMethods.print("" + a);
	}
	
}
		
	
	