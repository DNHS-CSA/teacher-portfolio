
public class palindrome
{
	// instance variables - replace the example below with your own
    private char[] aCandidate;
    private int Length; 
	private String Candidate;
	private String Log;
	
	public String getPaliCandidate() {
		return Candidate;
	}
	
	public String getPaliLog() {
		return Log;
	}
	
	public void setPaliLog(String log) {
		Log = log;
	}
	
	private void isPaliHelper()
	{
		this.Length = Candidate.length()-1;
		this.aCandidate  = Candidate.toCharArray();
	}
	
	public boolean isPali(String candidate, int method) {
		Candidate = candidate;
		// initialize and check
		String WordOrPhrase = this.Candidate;
		if (WordOrPhrase.length() < 2) {
    		this.setPaliLog(WordOrPhrase +" is to small to test");
			return false;
		}
		isPaliHelper();
		switch (method) {
		case 1:
			return palindromeTestIJ();
		case 2:
			return palindromeTestRecursion();
		case 3:
			return palindromeTestIJ();
		default:
    		this.setPaliLog(WordOrPhrase +" not run " + method + " unkown");
    		return false;
		}

	}
	
	public static String isPaliLog(String candidate, int method)
    {
		palindrome test = new palindrome();
        test.isPali(candidate, method);
        return test.getPaliLog();
    }
	
	public static void isPaliByConsole(int method)
    {
		palindrome test = new palindrome();
        String candidate = isolatedIO.inputString("Enter a word or phrase: ");
        test.isPali(candidate,method);
        System.out.println(test.getPaliLog());
    }

	private boolean palindromeTestIJ()
    {	
		// Entering IJ method
        String ijmsg = "by IJ method";
        isolatedIO.println( String.format("i = %s j = %d" ,Candidate, Length) );
        for (int i=0, j=this.Length; i < j;) 
        {
        	char lchar = Character.toLowerCase(aCandidate[i]);
        	char rchar = Character.toLowerCase(aCandidate[j]);
        	
            isolatedIO.println( String.format( "i = %c j = %c" ,lchar, rchar ));
            if ( !(Character.isLetter(lchar)) ) { 
                i++;
            } else if ( !(Character.isLetter(rchar)) ) {
                j--;
            } else if ( lchar == rchar) {
                i++; j--;
            } else {
            	updateLog(false, ijmsg);
                return false;
            }
        }
        updateLog(true, ijmsg);
        return true;
    }
	
	private boolean palindromeTestRecurse(String shrinker)
	{
        isolatedIO.println( String.format("%s" ,shrinker));
        int lindex = 0;
        int rindex = shrinker.length();

		char lchar = Character.toLowerCase(shrinker.charAt(0));
		char rchar = Character.toLowerCase(shrinker.charAt(rindex-1));

		if (! (Character.isLetter(lchar) )) {
			lindex++;
		} else if (! (Character.isLetter(rchar) )) {
			rindex--;
		} else if ( lchar == rchar ) {
			lindex++; rindex--;
		} else {
			return false;
		}
        
        isolatedIO.println( String.format("%d %d" ,lindex, rindex));
		return ( lindex >= rindex ? true : palindromeTestRecurse(shrinker.substring(lindex,rindex)) );		
	}

	private boolean palindromeTestRecursion()
    {	
		// Entering recursion method
        String msg = "by recursion method";
        String testStr = Candidate;
        if ( palindromeTestRecurse(testStr) ) {
            isolatedIO.println( "true" );
            updateLog(true, msg);
            return true;
        }
        isolatedIO.println( "false" );
        updateLog(false, msg);
        return false; 
    }
    
    private void updateLog(boolean isPali, String method)
    {
		this.setPaliLog( String.format ("** %s - %s %s **",
			Candidate,
			isPali 
			? "Is pali :)" 
			: "Not pali :(",
			method
			) );
        isolatedIO.println( this.getPaliLog() );
    }
    
}
