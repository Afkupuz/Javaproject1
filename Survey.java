package it152;

import java.util.Scanner;

/*
 * Survey project
 * Nicolas Helgeson
 */

/**
 *
 * @author nicolas
 */
public class Survey {
   
    //Phase 1 
    //survey variables
   private static int respondentID;
   private String surveyTitle;
   
   //Phase 2
   //Survey size pre-made
   private int numberOfSurveyQuestions = 3;
   private String[] surveyQuestions = new String[numberOfSurveyQuestions];
   //Response array questions on left, respondents on right
   //private int questionNumber = 3;
   private int respondentNumber = 3;
   private int[][] surveyResponses = new int[respondentNumber][numberOfSurveyQuestions];
  
//<editor-fold defaultstate="collapsed" desc="Phase1">
   
   //default constructor
   Survey() {
       this("Customer Survey");
   }
   
   //user variable constructor
   Survey(String surveyTitle) {
       respondentID = 0;
       this.surveyTitle = surveyTitle;
   }
   
   //getter that increments the ID
   public int generateRespondentID() {
       return ++respondentID;
   }
   
   //getter for title
   public String getTitle(){
       return surveyTitle;
   }
   
   //getter for ID
   public int getRespID() {
       return respondentID;
   }
   
//</editor-fold>
  
//<editor-fold defaultstate="collapsed" desc="Phase 2">
   
   //Takes 3 arguemnts and puts them into the response array based on question
   //number and respondentID
   public void logResponse(int questionNumber, int respondentID, int responseValue) {
       surveyResponses[respondentID][(questionNumber)]= responseValue;
   }
   
   //Uses the scanner to take string input from user and add to the surveyQuestions
   //array
   public void enterQuestions() {
       //accepts user input
       Scanner scan = new Scanner(System.in);
       int i;
       for (i=0; i < numberOfSurveyQuestions; i++){
       System.out.println("For question number "+ (i+1) +", please enter the question:");
       surveyQuestions[i] = scan.nextLine();
       }
   }
   
   //takes no arguments and lists the title of the survey and contents of
   //survey responses
   public void displaySurveyResults() {
       
       int rows = surveyResponses.length;
       int columns = surveyResponses[0].length;
       int r, c;
       
       System.out.println("Survey title: " + surveyTitle);
       
       for (r=0; r < rows ; r++) {
           System.out.print("Respondent " + r + ": ");
           for (c=0; c < columns ; c++) {
               System.out.print(surveyResponses[r][c] +" | ");
           }
           System.out.println("");
       }
       
   }
   
   //Takes argument for the question number and displays the responses to
   //the input
   public void displayQuestionStats(int questionNumber) {
       int i;
       System.out.println("Results for question " + questionNumber + ": " 
       + surveyQuestions[(questionNumber-1)]);
       for (i=0; i < surveyResponses.length; i++) {
           System.out.print(surveyResponses[i][(questionNumber-1)] + " | ");
       }
       System.out.println("");
   }
   
   //method to test questions
   public void displayQuestions() {
       int a;
       for (a=0; a < 3; a++){
           System.out.print("Question " +(a+1)+ ": ");
           System.out.println(surveyQuestions[a]);
       }
   }
   
//</editor-fold>
   
//<editor-fold defaultstate="collapsed" desc="Phase 3">
   //phase 3
  
   public int topRatedQuestion() {
       
       int q, r, sum, max = 0, questionNum = 0;
       
       for (q = 0; q < numberOfSurveyQuestions; q++) {
           sum = 0;
           for (r = 0; r < respondentNumber; r++) {
               sum += surveyResponses[q][r];
           }
           if (sum > max) {
               max = sum;
               questionNum = (q+1);
           }
       }
       //System.out.println("The question with the best response is question "+questionNum+
       //        " with an average response of "+(max/respondentNumber)+".");
       return questionNum;
   }
   
   public int lowRatedQuestion() {
       
       int q, r, sum, min = 1000, questionNum = 0;
       
       for (q = 0; q < numberOfSurveyQuestions; q++) {
           sum = 0;
           for (r = 0; r < respondentNumber; r++) {
               sum += surveyResponses[q][r];
           }
           if (sum < min) {
               min = sum;
               questionNum = (q+1);
           }
       }
       //System.out.println("The question with the lowest response is question "+questionNum+
       //        " with an average response of "+(min/respondentNumber)+".");
       return questionNum;
   }
   
   public void presentQuestion(int questionNum) {
       
       System.out.println("Question " +questionNum+ ": "+surveyQuestions[(questionNum-1)]);
   }
   
   public void presentQuestion(int questionNum, int respNum) {
       
       System.out.println("Respondent "+respNum+", please answer the following question"
               + " on a scale of 1 to 5:");
       System.out.println((questionNum+1)+": "+surveyQuestions[(questionNum)]);
   }
   
//</editor-fold>

//Phase 4
   
public int getQuestionNumber() {
    return numberOfSurveyQuestions;
}

public int getRespondentNumber() {
    return respondentNumber;
}


   
   
}//end class survey
