package model_search;
/**
	 * Write a description of class ProgrammingLanguages here.
	 
	 * @author (your name)
	 * @version (a version number or a date)
	 */
	import java.util.*;
	public class ProgrammingLanguagesMain 
	{
	        
        public static String printPython() {
        	 Python P = new Python(); 
 	         P.init();
        
	            // Show Python options
 	         String pythonOptions = "\n"+P.BirthDate.replace('^',' ')+"\n"+
	            P.Creator.replace('^',' ')+"\n"+
	            P.Owner.replace('^',' ')+"\n"+
	            P.ReasonForDemand.replace('^',' ')+"\n"+
	            P.GitHubUsageRank.replace('^',' ')+"\n"+
	            P.KeyCompanies.replace('^',' ')+"\n"+
	            P.AvgSalary.replace('^',' ')+"\n"+
	            P.ide.replace('^',' ')+"\n"+
	            P.frameworks.replace('^',' ')+"\n";
 	         return pythonOptions;
        }
        
        public static String printRuby() {
	         Ruby R = new Ruby();
	         R.init();
	         
	        String rubyOptions = "\n"+R.BirthDate.replace('^',' ')+"\n"+
	            R.Creator.replace('^',' ')+"\n"+
	            R.Owner.replace('^',' ')+"\n"+
	            R.ReasonForDemand.replace('^',' ')+"\n"+
	            R.GitHubUsageRank.replace('^',' ')+"\n"+
	            R.KeyCompanies.replace('^',' ')+"\n"+
	            R.AvgSalary.replace('^',' ')+"\n"+
	            R.ide.replace('^',' ')+"\n"+
	            R.frameworks.replace('^',' ');
	        return rubyOptions;
        }
        
        public static String printJava() {
   	         Java J = new Java();
   	         J.init();
   	         
   	      String javaOptions = "\n"+J.BirthDate.replace('^',' ')+"\n"+
          J.Creator.replace('^',' ')+"\n"+
          J.Owner.replace('^',' ')+"\n"+
          J.ReasonForDemand.replace('^',' ')+"\n"+
          J.GitHubUsageRank.replace('^',' ')+"\n"+
          J.KeyCompanies.replace('^',' ')+"\n"+
          J.AvgSalary.replace('^',' ')+"\n"+
          J.ide.replace('^',' ')+"\n"+
          J.frameworks.replace('^',' ')+"\n";
   	      
   	      return javaOptions;
        }
	            
	            public static String main(String input2) {
	           
	            	Python P = new Python(); 
	     	        P.init();
	     	        Swift S= new Swift();
	     	        S.init();
	     	        Ruby R = new Ruby();
	     	        R.init();
	     	        Java J = new Java();
	     	        J.init();
	            
	            String input=null;
	            try {
	                int aa = Integer.valueOf(input);/*if input is 0, returns string that will terminate main method*/
	                if(aa == 0) {
	                    System.out.println("You are done searching");
	                }
	            } catch(NumberFormatException e) {
	                int aa = 1;
	            } 
	            input2 = "^" + input2.toLowerCase() + "^"; /*adds ^^ to the string*/
	        
	            // Check Python
	            if(P.BirthDate.toLowerCase().indexOf(input2) >= 0 || 
	               P.Creator.toLowerCase().indexOf(input2) >= 0 || 
	               P.Owner.toLowerCase().indexOf(input2) >= 0 ||
	               P.ReasonForDemand.toLowerCase().indexOf(input2) >= 0 || 
	               P.GitHubUsageRank.toLowerCase().indexOf(input2) >= 0 || 
	               P.KeyCompanies.toLowerCase().indexOf(input2) >= 0 || 
	               P.AvgSalary.toLowerCase().indexOf(input2) >= 0 ||
	               P.ide.toLowerCase().indexOf(input2) >= 0 || 
	               P.frameworks.toLowerCase().indexOf(input2) >= 0) {
	                return "Python";
	            }
	                
	            // Check Java
	            if(J.BirthDate.toLowerCase().indexOf(input2) >= 0 || 
	               J.Creator.toLowerCase().indexOf(input2) >= 0 || 
	               J.Owner.toLowerCase().indexOf(input2) >= 0 ||
	               J.ReasonForDemand.toLowerCase().indexOf(input2) >= 0 || 
	               J.GitHubUsageRank.toLowerCase().indexOf(input2) >= 0 || 
	               J.KeyCompanies.toLowerCase().indexOf(input2) >= 0 || 
	               J.AvgSalary.toLowerCase().indexOf(input2) >= 0 ||
	               J.ide.toLowerCase().indexOf(input2) >= 0 || 
	               J.frameworks.toLowerCase().indexOf(input2) >= 0) {
	                return "Java";
	            }
	            
	            //Check Ruby
	            if(R.BirthDate.toLowerCase().indexOf(input2) >= 0 || 
	               R.Creator.toLowerCase().indexOf(input2) >= 0 || 
	               R.Owner.toLowerCase().indexOf(input2) >= 0 ||
	               R.ReasonForDemand.toLowerCase().indexOf(input2) >= 0 || 
	               R.GitHubUsageRank.toLowerCase().indexOf(input2) >= 0 || 
	               R.KeyCompanies.toLowerCase().indexOf(input2) >= 0 || 
	               R.AvgSalary.toLowerCase().indexOf(input2) >= 0 ||
	               R.ide.toLowerCase().indexOf(input2) >= 0 || 
	               R.frameworks.toLowerCase().indexOf(input2) >= 0) {
	                return "Ruby";
	            }
	            return "false";
	            }
	}
	

