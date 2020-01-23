package control_file_search;

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
import java.util.Scanner;

import util.ConsoleMethods;

import java.io.*;


public class Method2String
{  
	 private  boolean Found;
	 private  ArrayList<String> Lines;   	//Each element of ArrayList contains a line from file
	 private  ArrayList<String> Method;	//methods matched will be added to methods ArrayList
	 private  String Filenm;
	 private  String MethodName;
	 private  String Log;

	/*
	public static void main (String[] args)
    {
        //method name to be searched
        scan ("Vow");
    }  
    */ 
    
    public Method2String()
    {
    	Found = true;
    	Lines = new ArrayList<String>();
        Method = new ArrayList<String>();
        Log = "";
    }
    
    
    private void setTerms(String filenm, String method) {
		this.Filenm = filenm;
		this.MethodName = method;
	}
 
    
    private void scan ()
    {
        ConsoleMethods.println("In Method2String Scan" + Filenm);
        Scanner sc = null;
        int squig = 0;

        try 
        {
            sc = new Scanner(new File(Filenm));
            //Scanner reads every line and adds to ArrayList Lines
            while (sc.hasNextLine()) 
            {   
                Lines.add(sc.nextLine());
            }
            
            //Every word in each line is compared to passed in method
            for (int j=0; j<Lines.size(); j++) 
            {
            	if (squig > 0)
            	{
                    Method.add(Lines.get(j));
                    if (Lines.get(j).contains("{")) squig++;
                    if (Lines.get(j).contains("}")) squig--;
            		
            	}
           
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
                    else if (splitted[i].toLowerCase().contains(MethodName.toLowerCase()) 
                    && Lines.get(j).contains("{")) 
                    {   
                        //to confirm a method,there must be a curley bracket
                        Method.add(Lines.get(j));
                        squig = 1;

                    }
                    //checks if curley bracket is in the next line
                    else if ((i+1) < length && splitted[i].toLowerCase().contains(MethodName.toLowerCase()) 
                    && Lines.get(j+1).contains("{")) 
                    {
                        Method.add(Lines.get(j));
                        Method.add(Lines.get(++j));
                     
                        squig = 1;
                        
                        
                    }
                    else 
                    { 
                        Found = false;
                    }
                }
            }
            sc.close(); 
        } 
        catch (FileNotFoundException e) 
        {
            ConsoleMethods.println("File Not found");
        }
        ConsoleMethods.println("In MethodSearch Scan" + Method);
    }
       
    public static ArrayList<String> getMethod(String filenm, String method)	// Business logic driver
    {
        ConsoleMethods.println("In Method2String getMethod");
        Method2String test = new Method2String();
    	test.setTerms(filenm, method);
    	test.scan();
        return test.Method;
    }

    
    public static void main(String filenm, String method)
    {
        ConsoleMethods.println("In Method2String Main");
        
        // Call method to getLines of function
        ArrayList<String> lines = getMethod(filenm, method);
        lines.forEach(line -> ConsoleMethods.println(line));     	
    }

    
    public static void main(String[] args)
    {	
    	main("control_ap_exam/BinaryMathQuestions.java", "setupQuestionData");
    }
    

}
