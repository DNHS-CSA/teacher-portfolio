package control_palindrome;

import util.ConsoleMethods;

/**
 * Evaluates String as palindrome
 * a word, phrase, or sequence that reads the same backward as forward, e.g., madam or nurses run.
 * 
 * Contains 3 methods of evaluation: Loop, Recursion, Built in replace and compare
 * 
 * @version 1.0
 * @author John Mortensen
 */

public class Palindrome
{
	// Instance variables
	private String Candidate;
	private String Log;
	
	public static void main(String[] args) 						// Console driver
    {
		// Input using console
        String candidate = ConsoleMethods.inputString("Enter a word or phrase: ");

        // Evaluate by all methods
		Palindrome test = new Palindrome();
		test.setPaliCandidate(candidate);
        test.isPali(1);
        test.isPali(2);
        test.isPali(3);
    }
	
	public static String isPaliLog(String candidate, int method)	// Business logic driver
    {
		// Tests candidate and returns result message
		Palindrome test = new Palindrome();
		test.setPaliCandidate(candidate);
        test.isPali(method);
        return test.getPaliLog();
    }
	
	public String getPaliCandidate() {
		// Getter
		return Candidate;
	}
	
	public String getPaliLog() {
		// Getter
		return Log;
	}
	
	private void setPaliCandidate(String candidate) {
		// Setter
		Candidate = candidate;
	}
	
	private void setPaliLog(String log) {
		// Setter
		Log = log;
	}
	
	private void setPaliLog(boolean isPali, String method)
    {
    	// Log to persist in Object
		this.setPaliLog( String.format ("\"%s\"  %s  %s",
			Candidate,
			isPali 
			? "Is pali :)" 
			: "Not pali :(",
			method
			) );
        ConsoleMethods.println( this.getPaliLog() );
    }
	
	private boolean isPali(int method) 
	{
		// Base condition, no need to test 0 or 1 condition
		if (Candidate.length() < 2) {
    		this.setPaliLog(Candidate +" is to small to test");
			return true;
		}
		
		// Select testing method
		switch (method) {
		case 1:
			return palindromeTestIJ();
		case 2:
			return palindromeRecurseDriver();
		case 3:
			return palindromeReplace();
		default:
    		this.setPaliLog(Candidate +" not run " + method + " unkown");
    		return false;
		}

	}

	private boolean palindromeReplace()
	{
		// Entering Replace (Built-in) method
        String msg = "Replace method";
        ConsoleMethods.println( String.format("\n%s, Candidate: \"%s\",  Length = %d" ,msg, Candidate, Candidate.length()) );
    	int step = 0;


        // Built in methods to remove special characters by regular expression (regex)
        String forwardStr = Candidate.replaceAll("[^a-zA-Z0-9]", "");
        ConsoleMethods.println( String.format( "Step %d: Prepare string one \"%s\" to  \"%s\"", step++, Candidate, forwardStr ));

        // Built in method in StringBuilder to reverse string and convert back to string
		String reverseStr = new StringBuilder(forwardStr).reverse().toString();
        ConsoleMethods.println( String.format( "Step %d: Prepare string two \"%s\" to  \"%s\"", step++, forwardStr, reverseStr ));

		// Compare strings by ignoring case
        ConsoleMethods.println( String.format( "Step %d: Compare ignoring case \"%s\" to reverse \"%s\"", step++,forwardStr, reverseStr ));
        boolean result = (forwardStr.equalsIgnoreCase(reverseStr)); 
		if (result) {
			setPaliLog(true, msg);
		} else {
			setPaliLog(false, msg);
		}
		
		return result;	
	}

	private boolean palindromeTestIJ()
    {	
		// Entering IJ method
        String msg = "IJ method";
        ConsoleMethods.println( String.format("\n%s, Candidate: \"%s\",  Length = %d" ,msg, Candidate, Candidate.length()) );
        
    	int length = Candidate.length()-1;
    	int step = 0;
        for (int i=0, j=length; i < j; step++ ) 
        {
        	char lchar = Character.toLowerCase(Candidate.charAt(i)); 
        	char rchar = Character.toLowerCase(Candidate.charAt(j));
        	
    		// Compare is Character by Character
            ConsoleMethods.println( String.format( "Step %d: Candidate(%d) = %c -- Candidate(%d) = %c" , step, i, lchar, j, rchar ));
            if ( !(Character.isLetterOrDigit(lchar)) ) {  
                ConsoleMethods.println( String.format( " skip left %c" ,lchar ));
                i++;
            } else if ( !(Character.isLetterOrDigit(rchar)) ) {
                ConsoleMethods.println( String.format( " skip right %c", rchar ));
                j--;
            } else if ( lchar == rchar) {
    			ConsoleMethods.println( String.format(" eq left %c = right %c" , lchar, rchar));
                i++; j--;
            } else {
    			ConsoleMethods.println( String.format(" not eq left %c = right %c" , lchar, rchar));
            	setPaliLog(false, msg);
                return false;
            }
        }
        setPaliLog(true, msg);
        return true;
    }
	
	private boolean palindromeRecurseDriver()
    {	
        // Recursion driver,  used to setup recursion method
		String msg = "Recursion method";
        ConsoleMethods.println( String.format("\n%s, Candidate: \"%s\",  Length = %d" ,msg, Candidate, Candidate.length()) );

        String testStr = Candidate;
        boolean result = palindromeTestRecurse(testStr, 0);
		if (result) {
			setPaliLog(true, msg);
		} else {
			setPaliLog(false, msg);
		}
		
		return result;	
    }
	
	private boolean palindromeTestRecurse(String shrinker, int step)
	{
		// Entering recursion method
		int lindex = 0;
        int rindex = shrinker.length();
        
        // String reduces on each recursion
        ConsoleMethods.println( String.format("Step %d: Candidate \"%s\"" , step, shrinker ) );
		char lchar = Character.toLowerCase(shrinker.charAt(0));
		char rchar = Character.toLowerCase(shrinker.charAt(rindex-1));

		if (! (Character.isLetterOrDigit(lchar) )) {
	        ConsoleMethods.println( String.format(" skip left %c" , lchar));
			lindex++;
		} else if (! (Character.isLetterOrDigit(rchar) )) {
			ConsoleMethods.println( String.format(" skip right %c" , rchar));
			rindex--;
		} else if ( lchar == rchar ) {
			ConsoleMethods.println( String.format(" eq left %c = right %c" , lchar, rchar));
			lindex++; rindex--;
		} else {
			ConsoleMethods.println( String.format(" not eq left %c = right %c" , lchar, rchar));
			return false;
		}
        
		// Java recursion acts funny if True and Recursion are not at the end, thus placement and use of indexes
		return ( ((rindex - lindex) > 2) ? palindromeTestRecurse(shrinker.substring(lindex,rindex), ++step) : true );		
	}
    
}
