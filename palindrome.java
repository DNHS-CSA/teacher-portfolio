
public class palindrome
{
    // instance variables - replace the example below with your own
    private int x;
    

    /**
     * Constructor for objects of class palindromepart2
     */
    public void Palindrome()
    {
        isolatedIO.println("enter a word");
      
        String testword = "";
        Boolean pali= false;
        
        testword = isolatedIO.inputString(testword);
        testword = testword.toLowerCase( );
        
        String replaceString = testword.replaceAll("[\\W]","");
        
        
        
     for (int i = 0, j = testword.length() - 1; i<replaceString.length();i++,j--)
     {
      if(replaceString.charAt(i) != replaceString.charAt(j))
             pali = false;

     
     if(replaceString.charAt(i) == replaceString.charAt(j))
       pali = true;
     
     
     }
     if (pali)
      System.out.println(replaceString +" is a palindrome");
     else 
     System.out.println(replaceString +" is not a palindrome");
   
   }

}
