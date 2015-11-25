/*
 * Survey project
 * Nicolas Helgeson
 */
package it152;

import java.util.Scanner;

/**
 *
 * @author nicolas
 */

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
/*
//<editor-fold defaultstate="collapsed" desc="Phase 1">
        //Phase 1
        System.out.println("-------------");
        System.out.println("Phase 1");
        System.out.println("-------------");
        
        //test default constructor
        Survey mySurveyBlank = new Survey();
        System.out.println("Title: "+mySurveyBlank.getTitle());
        
        //test variable constructor
        Survey mySurvey2 = new Survey("Tell Us What You Think");
        System.out.println("Title: "+mySurvey2.getTitle());
        
        //test respondant ID
        System.out.println("Test increment ID1: "+mySurvey2.generateRespondentID());
        System.out.println("Test increment ID2: "+mySurvey2.generateRespondentID());
        System.out.println("Test increment ID3: "+mySurvey2.generateRespondentID());
        
//</editor-fold>
                
//<editor-fold defaultstate="collapsed" desc="Phase 2">
//Phase 2
        System.out.println("-------------");
        System.out.println("Phase 2");
        System.out.println("-------------");
        
        //create questions 
        mySurvey2.enterQuestions();
        //mySurvey2.enterQuestions("How do you feel?", "How did you feel yesterday?",
        //        "How would you like to feel?");
        //test questions
        mySurvey2.displayQuestions();
        
        //enter information into survey results array (question number,
        //respondent ID, answer value)
        int i;
        for (i=0; i < 3 ; i++) {
            mySurvey2.logResponse((i+1),0,(i+2));
            mySurvey2.logResponse((i+1),1,(i+1));
            mySurvey2.logResponse((i+1),2,(i+3));
        }
        
        //test survey results array display
        mySurvey2.displaySurveyResults();
        
        //test question stat display (question number)
        mySurvey2.displayQuestionStats(1);
        
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Phase 3">
//phase 3
        System.out.println("-------------");
        System.out.println("Phase 3");
        System.out.println("-------------");
        
        
        System.out.println("High rated question is number: "+mySurvey2.topRatedQuestion());
        
        System.out.println("Low rated question is number: "+mySurvey2.lowRatedQuestion());
        
        mySurvey2.presentQuestion(1);
        
        mySurvey2.presentQuestion(0, 0);
        
//</editor-fold>
*/


//Phase 4/5        
ConductSurvey conduct = new ConductSurvey();

conduct.main();


       
       
       
       
       
  }//end main
    }//end test class
