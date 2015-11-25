/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it152;

import java.util.Scanner;
/**
 *
 * @author nicolas
 */
public class ConductSurvey {
    
    
    public void main() {
    
    
    //scanner to log user input
    Scanner scan = new Scanner(System.in);
    
    //variable to test if user wants their own title
    String userConfirmation;

    //variable to get user title
    String surveyTitle;
    
    //initialize the mySurvey class
    Survey mySurvey = new Survey();
            
    //prompt user
    System.out.println("Hello and welcome to the survey generator. Would you "
            + "like to create your own tile? (yes or no)");
    userConfirmation = scan.nextLine();
    userConfirmation = userConfirmation.toLowerCase();
    int counter = 0;
    
    do {
        
        switch (userConfirmation) {
            
            case "yes":
                {
                    System.out.println("Please enter the title of your survey:");
                    //set variable to user enter
                    surveyTitle = scan.nextLine();
                    mySurvey = new Survey(surveyTitle);
                    counter = 1;
                    break;
                }
            case "no":
                {
                    System.out.println("Your survey has defaulted to 'Customer Survey'.");
                    //create default survey
                    mySurvey = new Survey();
                    counter = 1;
                    break;
                }
            default:
                System.out.println("Error: Please respond 'yes' or 'no'.");
                userConfirmation = scan.nextLine();
                userConfirmation = userConfirmation.toLowerCase();
                counter = 0;
                break;
        }
        
        
    } while (counter == 0);
    
    
    //request user questions
    mySurvey.enterQuestions();
    
    //prompt user
    System.out.println("Your survey is now ready to be presented to the respondents,");
    System.out.println("please have the first respondent answer the following questions:");
    System.out.println("--------------");
    
    //variables for user answers
    int q, r;
    String userAnswer, enterQuestionNumber;
    int userAnswerInt, QuestionNumberInt;
    int verifyUserInput, verifyQuestionNumber;
    
    //begin for loop that allows respondents to enter question answers
    
    //initial for loop cycles users
    for (r = 0; r < mySurvey.getRespondentNumber(); r++) {
    
    //second for loop cycles questions
        for (q=0 ; q < mySurvey.getQuestionNumber() ; q++) {
            userAnswerInt = -1;
            verifyUserInput = 0;
            mySurvey.presentQuestion(q, r);
    
    //do while loop ensures correct user input        
            do {
            userAnswer = scan.nextLine();
            try {userAnswerInt = Integer.valueOf(userAnswer);
            }
            catch (NumberFormatException e) {
            }
        
            if (userAnswerInt <= 5 && userAnswerInt >= 1){
            verifyUserInput = 2;
            }
            else {
            System.out.println("Your answer was not between 1 and 5, please put "
                    + "a number between 1 and 5:");
            }
            }while (verifyUserInput < 1);
        
            mySurvey.logResponse(q, r, userAnswerInt);
        
            }//end question loop
        
    //display question stats    
        System.out.println("--------");
        System.out.println("Results:");
    
        mySurvey.displaySurveyResults();
    
        System.out.println("High rated question is number: "+mySurvey.topRatedQuestion());
        
        System.out.println("Low rated question is number: "+mySurvey.lowRatedQuestion());
    
    //provides break for next user and finalizes     
        if ((r+1) == mySurvey.getRespondentNumber()){
            System.out.println("--------");
            System.out.println("The survey is now over.");
            System.out.println("--------");
    
    //do while loop allows for repeated selection of question specifics         
        do {
            QuestionNumberInt = -1;
            System.out.println("Please enter the number of the question (1 - " +
                    mySurvey.getQuestionNumber() + ") you would like"
                + " to see the stats on if you are done put 0");
        
            enterQuestionNumber = scan.nextLine();
        
            try {
                QuestionNumberInt = Integer.valueOf(enterQuestionNumber);
            }
            catch (NumberFormatException e) {
            }
            if (QuestionNumberInt > 0 && QuestionNumberInt < (mySurvey.getQuestionNumber()+1)){
                mySurvey.displayQuestionStats(QuestionNumberInt);
            }
            else if (QuestionNumberInt == 0) {
                System.out.println("Thank you!");
            }
            else {
                System.out.println("Error - Unrecognized response:");
            }
            
            }while (QuestionNumberInt != 0);
            }//end if
            else{
                System.out.println("--------");
                System.out.println("Next respondent please.");
                System.out.println("--------");
            }//end else
    }//end respondent loop
    
    
    }//end main
}//end class
