import java.util.Scanner;

public class isolatedIO {

   public static String inputString(String txt)
   {
	   System.out.println(txt);
	   Scanner e = new Scanner (System.in);
	   return e.nextLine();
   }
   
   public static void printChar(char txt)
   {
	   System.out.println(txt);
   }
   
   public static void println(String txt)
   {
	   System.out.println(txt);
   }
   
   public static int inputInt(String txt)
   {
	   System.out.println(txt);
	   Scanner e = new Scanner(System.in);
	   return e.nextInt();
   }
	   
}
