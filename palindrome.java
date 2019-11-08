
public class palindrome
{
	private String Candidate;
	private String Log;
	
	public String getPaliCandidate() {
		return Candidate;
	}
	
	public String getPaliLog() {
		return Log;
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
    		this.setLog(WordOrPhrase +" is to small to test");
			return false;
		}
        setLog("");
        
        // remove extraneous characters
        String testword = WordOrPhrase.toLowerCase( ).replaceAll("\\W","");

        String ijmsg = "palindrome by IJ method";
        for (int i = 0, j = testword.length() - 1; i < j;i++,j--)
        {
        	if(testword.charAt(i) != testword.charAt(j)) {
        		this.setLog("-" + WordOrPhrase +"- is not " + ijmsg);
        		return false;
        	}

        }
		this.setLog("*" + WordOrPhrase +"* is " + ijmsg);
		return true;
   }
    
    private void setLog(String log) {
		Log = log;
	}
	
    
}
