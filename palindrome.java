
public class palindrome
{
	// instance variables - replace the example below with your own
    private char[] aCandidate;
    private int length; 
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
		this.length = Candidate.length()-1;
		this.aCandidate  = Candidate.toCharArray();
	}
	
	public boolean isPali(String candidate) {
		Candidate = candidate;
		return palindromeTest();
	}
	
	public static String isPaliLog(String candidate)
    {
		palindrome test = new palindrome();
        test.isPali(candidate);
        return test.getPaliLog();
    }
	
	public static void isPaliByConsole()
    {
		palindrome test = new palindrome();
        String candidate = isolatedIO.inputString("enter a word");
        test.isPali(candidate);
        System.out.println(test.getPaliLog());
    }

	private boolean palindromeTest()
    {
		// initialize and check
		String WordOrPhrase = this.Candidate;
		if (WordOrPhrase.length() < 2) {
    		this.setPaliLog(WordOrPhrase +" is to small to test");
			return false;
		}
		isPaliHelper();
		
		// Entering IJ method
        String ijmsg = "palindrome by IJ method";
        isolatedIO.println( String.format("i = %s j = %d" ,WordOrPhrase, length) );
        for (int i=0, j=this.length; i < j;) 
        {
            isolatedIO.println( String.format("i = %c j = %c" ,aCandidate[i], aCandidate[j]) );
            if ( !(Character.isLetter(aCandidate[i])) ) { 
                i++;
            } else if ( !(Character.isLetter(aCandidate[j])) ) {
                j--;
            } else if (Character.toLowerCase(aCandidate[i]) == Character.toLowerCase(aCandidate[j])) {
                i++; j--;
            } else {
            	updateLog(false, ijmsg);
                return false;
            }
        }
        updateLog(true, ijmsg);
        return true;
    }
    
    private void updateLog(boolean isPali, String method)
    {
		this.setPaliLog( String.format ("** %s - %s %s **",
			Candidate,
			isPali 
			? "++Is a palindrome++" 
			: "--Not a palindrome--",
			method
			) ); 		
    }
    
}
