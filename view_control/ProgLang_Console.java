package view_control;

import java.util.*;

import control_prog_lang.Java;
import control_prog_lang.ProgLangManager;
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
    	ConsoleMethods.clearScreen();
        Scanner scan = new Scanner(System.in);
        
        // Make Programming Language Objects
        ProgLangManager pLM = new ProgLangManager();

        boolean cont = true; /*used in do while loop to keep everything running*/
        ConsoleMethods.println("Hi Welcome To The Programming Languages Program!");
        do {
        
        int input = 0;
        boolean a = false; /*used in loop below to verify input*/
        int errorCount = 0; /*used to prevent infinate loop*/
        do {
        	ConsoleMethods.println("=========================");
        	ConsoleMethods.println("MENU SELECTION ATTRIBUTES");
        	ConsoleMethods.println("=========================");
        	ConsoleMethods.println("Press 0 at anytime to quit");
        	ConsoleMethods.println("Press 1 to see list of possible search parameters");
        	ConsoleMethods.println("Press 2 to begin searching");
            a = false;
            try {
                input = Integer.parseInt(scan.nextLine());
            } catch(NumberFormatException e) {
                a = true;
                ConsoleMethods.println("Try again");
                errorCount++;
                if(errorCount >= 10) {
                    ConsoleMethods.println("You are too stupid to run this program."); /*if more than 10 errors, exit*/
                    cont = false;
                }
            }
        } while(a && (0 <= input) && (input <= 2) && (errorCount < 10)); /*only accept inputs between 0 and 2*/
         switch(input)
        {
            case 0:
            cont = false;
            ConsoleMethods.println("You are done searching."); /*input 0 terminates code*/
            break;
            
            case 1:
            pLM.displayTest();
            break;
            
            case 2:
            ConsoleMethods.println("Input parameter");
            String input2 = scan.nextLine();
            try {
                int aa = Integer.valueOf(input);/*if input is 0, returns string that will terminate main method*/
                if(aa == 0) {
                    ConsoleMethods.println("You are done searching");
                    break;
                }
            } catch(NumberFormatException e) {
                int aa = 1;
            } 
            ConsoleMethods.println( pLM.searchProgLangs(input2) );            
            break;
        
        }
        }while (cont);
}
}

