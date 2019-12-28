package view_control;

import java.util.*;

import control_prog_lang.Java;
import control_prog_lang.Python;
import control_prog_lang.Ruby;
import control_prog_lang.Swift;
import util.ConsoleMethods;

/**
	 * Write a description of class ProgrammingLanguages here.
	 
	 * @author (your name)
	 * @version (a version number or a date)
	 */
	public class ProgLang_Console
	{
	    public static void main(String[] args) {
	     System.out.print('\u000C'); //clears screen
	     System.out.println("\u000c\r");
	        Scanner scan = new Scanner(System.in);
	        
	        // Make Programming Language Objects
	        Python P = new Python(); 
	        Swift S= new Swift();
	        Ruby R = new Ruby();
	        Java J = new Java();
	        boolean cont = true; /*used in do while loop to keep everything running*/
	        System.out.println("Hi Welcome To The Programming Languages Program!");
	        do {
	        
	        int input = 0;
	        boolean a = false; /*used in loop below to verify input*/
	        int errorCount = 0; /*used to prevent infinate loop*/
	        do {
	            System.out.println("=========================");
	            System.out.println("MENU SELECTION ATTRIBUTES");
	            System.out.println("=========================");
	            System.out.println("Press 0 at anytime to quit");
	            System.out.println("Press 1 to see list of possible search parameters");
	            System.out.println("Press 2 to begin searching");
	            a = false;
	            try {
	                input = Integer.parseInt(scan.nextLine());
	            } catch(NumberFormatException e) {
	                a = true;
	                System.out.println("Try again");
	                errorCount++;
	                if(errorCount >= 10) {
	                    System.out.println("You are too stupid to run this program."); /*if more than 10 errors, exit*/
	                    cont = false;
	                }
	            }
	        } while(a && (0 <= input) && (input <= 2) && (errorCount < 10)); /*only accept inputs between 0 and 2*/
	         switch(input)
	        {
	            case 0:
	            cont = false;
	            System.out.println("You are done searching."); /*input 0 terminates code*/
	            break;
	            
	            case 1:
	            // Show Python options
	            ConsoleMethods.println(P.toString());
	            
	            // Show JavaScript options
	            ConsoleMethods.println(J.toString());
	            
	            // Show Ruby options
	            ConsoleMethods.println(J.toString());

	            break;
	            
	            case 2:
	            System.out.println("Input parameter");
	            String input2 = scan.nextLine();
	            try {
	                int aa = Integer.valueOf(input);/*if input is 0, returns string that will terminate main method*/
	                if(aa == 0) {
	                    System.out.println("You are done searching");
	                    break;
	                }
	            } catch(NumberFormatException e) {
	                int aa = 1;
	            } 
	            
	            // re-implement
	            //ConsoleMethods.println( control_prog_lang.AttributesSearch.main(input2));
	            
	            break;
	        
	    }
	}while (cont);
}
}

