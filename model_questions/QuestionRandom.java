package model_questions;

import java.util.Random;

import util.ConsoleMethods;	// Console support

/**
 * QuestionRandom class is intended to support asking question on test by randomizing order
 *
 * @author (John Mortensen)
 * @version (1.0)
 */
public class QuestionRandom extends Question
{
	
    /**
     * Constructor for objects of class Question
     * 
     * @param  void
     */
    public QuestionRandom()
    {
    	// This outputs constructor being run
        ConsoleMethods.println("QuestionRandom class constructor");
        
        Random rand = new Random();
    	choiceOffset = rand.nextInt(answers.length);
    	
    	// Output showing randomization
    	ConsoleMethods.println("choiceOffset: "+choiceOffset);
    }
      
    /**
     * Use Modulo arithmetic to randomly offset choices
     *
     */
    @Override
    final public void setupQuestion() {
    	// This outputs constructor being run
        ConsoleMethods.println("QuestionRandom class setupQuestion Override method");
        
        // number of fixed answers
     	int modBase = choiceEfixed ? answers.length - 1 : answers.length;
     		
    	// scramble logic using modulo math
    	aOffset = choiceOffset % modBase;
    	bOffset = (choiceOffset+1) % modBase;
    	cOffset = (choiceOffset+2) % modBase;
    	dOffset = (choiceOffset+3) % modBase;
    	eOffset = choiceEfixed ? answers.length-1 : (choiceOffset+4) % modBase;
    	
    	// call super for standardized assignment
    	super.setupQuestion();
    	
    	// answer key set to match choice offset
		ConsoleMethods.println("answerKey original: " +answerKey);
    	switch (answerKey) {
		case charA:
			answerKey = answers[aOffset];
			break;
		case charB:
			answerKey = answers[bOffset];
			break;
		case charC:
			answerKey = answers[cOffset];
			break;
		case charD:
			answerKey = answers[dOffset];
			break;
		case charE:
			answerKey = answers[eOffset];
			break;
    	}
    	
    	/* Remaining code is Console information to show reordering */
    	
    	// Outputs showing after randomization answerKey
		ConsoleMethods.println("answerKey after offset: " +answerKey);
		
    	// Outputs showing randomization of letters
    	ConsoleMethods.printChar(answers[0]);
    	ConsoleMethods.printChar(answers[aOffset]);
    	ConsoleMethods.printChar('-');
    	ConsoleMethods.printChar(answers[1]);
    	ConsoleMethods.printChar(answers[bOffset]);
    	ConsoleMethods.printChar('-');
    	ConsoleMethods.printChar(answers[2]);
    	ConsoleMethods.printChar(answers[cOffset]);
    	ConsoleMethods.printChar('-');
    	ConsoleMethods.printChar(answers[3]);
    	ConsoleMethods.printChar(answers[dOffset]);
    	ConsoleMethods.printChar('-');
    	ConsoleMethods.printChar(answers[4]);
    	ConsoleMethods.printChar(answers[eOffset]);
    	ConsoleMethods.println();
    }
  
}
