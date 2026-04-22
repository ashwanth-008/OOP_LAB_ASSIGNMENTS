// creating TA (teaching assistant) class using INHERITANCE
//TA is basically a student except they also assist in grading.
package model;
public class TeachingAssistant extends Student {
    public void assistGrading()
    { 
        System.out.println("TA assisting in grading..."); 
    }
}
