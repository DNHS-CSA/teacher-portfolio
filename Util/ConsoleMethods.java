package Util;


/**
 * Static methods related to Console input and output
 * 
 * @author John Mortensen
 * @version 1.0
 */
import java.util.Scanner;

public class ConsoleMethods {

   public static String inputString(String txt)
   {
	   System.out.println(txt);
	   Scanner input = new Scanner (System.in);
	   return input.nextLine();
   }
   
   public static void printChar(char txt)
   {
	   System.out.print(txt);
   }
   
   public static void print(String txt)
   {
	   System.out.print(txt);
   }
   
   public static void println()
   {
	   System.out.println("\n");
   }
   
   public static void println(String txt)
   {
	   System.out.println(txt);
   }
   
   public static int inputInt(String txt)
   {
	   System.out.println(txt);
	   Scanner input = new Scanner(System.in);
	   return input.nextInt();
   }
	   
}
