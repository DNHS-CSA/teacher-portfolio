package AP_Exam;
/**
 * MidTermTest is intended to teach Object Oriented Methodology, the JAVA language,
 * Computer Science principles, and Agile project methodology while be very active
 * in coding.  Here are some additional guidelines to the project... 
 * 
 *      i)      While running MidTermTest it is executing and evaluating language proficiency
 *              of Tester
 *      ii)     While coding MidTermTest we are learning detail syntax and semantics of Java
 *      iii)    MidTermTest is dependent on class hierarchy (i.e. Question) as you enhance
 *              the MidTermTest project it will assist in learning JAVA coding and methodology
 *      iv)     MidTermTest will be built in class as a part of a 6 week project 
 *      v)      MidTermTest project members will look to bring applicable labs and lectures into 
 *              test with the intention of minimizing hard coding and have execution interpret 
 *              correct and incorrect answers
 *      vi)     MidTermTest can be extended by any class member as long as they follow class 
 *              project guidelines and version control protocol
 *      vi)     MidTermTest will contain capability to  be run in abbreviated or comprehensive 
 *              test formats
 *      vii)    MidTermTest will calculate question attempted, questions answered correctly and 
 *              save results
 *      viii)   MidTermTest will randomize test execution and problem execution to ensure learing
 *              is thorough, versus simple memorizing the answers
 *
 * @authors John Mortensen
 * @version 1.0
 * @created    August 29, 2019
 */


public class AP_Console
{
 
  /**
   *  The main program for the MidTerm class
   *
   * @param  args  The command line arguments
   */
  public static void main()
  {
     // BlueJ clear console command
     System.out.print("\u000C");
    
    String menuTotalMsg = new String();
    String menuMsg[] = new String[5];
    boolean running = true;

    while (running) 
    {
        // Local variable
        int swValue;
        
        // Display menu graphics
        System.out.println("============================");
        System.out.println("  MidTerm Questions        |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|      0. Exit             |");
        System.out.println("|      1. Math             |"+ menuMsg[1]);
        System.out.println("|      2. Binary Math      |"+ menuMsg[2]);
        System.out.println("|      3. Data Conversion  |"+ menuMsg[3]);
        System.out.println("|                          |"+ menuTotalMsg);
        System.out.println("============================");

        swValue = Keyinput.inInt(" Select option: ");
    
        // Switch construct
        switch (swValue) 
        {
            case 1:
              menuMsg[1] = MathQuestions.mainTest();
              menuTotalMsg = Scoring.getCounterTotalMsg();
              break;
            case 2:
              menuMsg[2] = BinaryMathQuestions.mainTest();
              menuTotalMsg = Scoring.getCounterTotalMsg();
              break;
            case 3:
              menuMsg[3] = DataTypeQuestions.mainTest();
              menuTotalMsg = Scoring.getCounterTotalMsg();
              break;
            case 0:
              System.out.println("Exit selected");
              running = false;
              break;
            default:
              System.out.println("Invalid selection");
        }
    }
  }
}


