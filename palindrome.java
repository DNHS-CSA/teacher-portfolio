
public class palindrome
{
    
    public void Palindrome()
    {
        isolatedIO.println("enter a word");
      
        String testword = "";
        Boolean pali= false;
        
        testword = isolatedIO.inputString(testword);
        testword = testword.toLowerCase( ).replaceAll("\\W","");
                
        for (int i = 0, j = testword.length() - 1; i < j;i++,j--)
        {
        	if(testword.charAt(i) != testword.charAt(j)) {
        		System.out.println(testword +" is not a palindrome");
        		return;
        	}

        }
        System.out.println(testword +" is a palindrome");
   }

}
