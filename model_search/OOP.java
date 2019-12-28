package model_search;
/**
 * Write a description of class OOP here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OOP 
{
    String ProgLang;
    String BirthDate;
    String Creator;
    String Owner;
    String ReasonForDemand;
    String GitHubUsageRank;
    String KeyCompanies;
    String AvgSalary;
    String ide;
    String frameworks;
    //defining variables that are info for later to set/get
    
    public String toString() {
    	// Standard Object to String method
    	return "\n"+ 
    		ProgLang +"\n"+
    		BirthDate + "\n"+
            Creator + "\n"+
            Owner + "\n"+
            ReasonForDemand + "\n"+
            GitHubUsageRank + "\n"+
            KeyCompanies + "\n"+
            AvgSalary + "\n"+
            ide + "\n"+
            frameworks + "\n";
   	
    }
    
    public String getKey()
    {
    	return ProgLang;
    }

}

