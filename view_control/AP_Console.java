package view_control;

import control_ap_exam.BinaryMathQuestions;
import control_ap_exam.DataTypeQuestions;
import control_ap_exam.MathQuestions;
import model_questions.Question;
import util.ConsoleMethods;

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
  public static void main(String[] args)
  {
    // BlueJ clear console command
    ConsoleMethods.clearScreen();
    
    String menuTotalMsg = new String();
    String menuMsg[] = new String[5];
    boolean running = true;

    while (running) 
    {
        // Local variable
        int swValue;
        
        // Display menu graphics
        ConsoleMethods.println("============================");
        ConsoleMethods.println("  MidTerm Questions        |");
        ConsoleMethods.println("============================");
        ConsoleMethods.println("| Options:                 |");
        ConsoleMethods.println("|      0. Exit             |");
        ConsoleMethods.println("|      1. Math             |"+ menuMsg[1]);
        ConsoleMethods.println("|      2. Binary Math      |"+ menuMsg[2]);
        ConsoleMethods.println("|      3. Data Conversion  |"+ menuMsg[3]);
        ConsoleMethods.println("|                          |"+ menuTotalMsg);
        ConsoleMethods.println("============================");

        swValue = ConsoleMethods.inputInt(" Select option: ");
    
        // Switch construct
        switch (swValue) 
        {
            case 1:
              menuMsg[1] = MathQuestions.mainTest();
              menuTotalMsg = Question.getCounterTotalMsg();
              break;
            case 2:
              menuMsg[2] = BinaryMathQuestions.mainTest();
              menuTotalMsg = Question.getCounterTotalMsg();
              break;
            case 3:
              menuMsg[3] = DataTypeQuestions.mainTest();
              menuTotalMsg = Question.getCounterTotalMsg();
              break;
            case 0:
              ConsoleMethods.println("Exit selected");
              running = false;
              break;
            default:
              ConsoleMethods.println("Invalid selection");
        }
    }
  }
}


