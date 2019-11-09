
/**
 * Searches PigLatinator.java for methods that match the input "Vow"
 * 
 * Excludes possibilities of calling methods with a dot
 * Checks for curley brackets in line with method and the proceeding line
 * Searches for methods that match and ignores case
 * Returns found methods as the methods (ArrayList)
 * found (boolean) indicates if methods were found or not
 * 
 * @author Sydney Hsieh
 * @version 2
 */

import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class MethodSearch
{  
	 private static boolean Found;
	 private static ArrayList<String> Lines;   	//Each element of ArrayList contains a line from file
	 private static ArrayList<String> Methods;	//methods matched will be added to methods ArrayList
	 private static String Filennm;
	 private static String Log;

	/*
	public static void main (String[] args)
    {
        //method name to be searched
        scan ("Vow");
    }  
    */ 
    
    public MethodSearch()
    {
    	Found = true;
    	Lines = new ArrayList<String>();
        Methods = new ArrayList<String>();
        Filennm = "PigLatinator.java";
        Log = "";
    }
    
    public static void scan (String method)
    {
        Scanner sc = null;

        try 
        {
            sc = new Scanner(new File(Filennm));
            //Scanner reads every line and adds to ArrayList Lines
            while (sc.hasNextLine()) 
            {   
                Lines.add(sc.nextLine());
            }
            
            //Every word in each line is compared to passed in method
            for (int j=0; j<Lines.size(); j++) 
            {
                //splitting array list by spaces
                String[] splitted = Lines.get(j).split(" |\\(");
                
                int length = splitted.length;
                for(int i = 0 ; i<length; i++)
                {
                    if (splitted[i].contains("."))
                    {
                       //if line contains a dot, a method is being called
                       Found = false;
                    }
                    else if (splitted[i].toLowerCase().contains(method.toLowerCase()) 
                    && Lines.get(j).contains("{")) 
                    {   
                        //to confirm a method,there must be a curley bracket
                        Methods.add(splitted[i]);
                    }
                    //checks if curley bracket is in the next line
                    else if ((i+1) < length && splitted[i].toLowerCase().contains(method.toLowerCase()) 
                    && Lines.get(j+1).contains("{")) 
                    {
                        Methods.add(splitted[i]);
                    }
                    else 
                    { 
                        Found = false;
                    }
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            ConsoleMethods.println("File Not found");
        }

        sc.close(); 
    }
}
