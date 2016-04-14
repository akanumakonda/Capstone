import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * Write a description of class Doctor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Doctor
{
    /** description of instance variable x (add comment for each instance variable) */
    private ArrayList<String> potentialDis;
    /**
     * Default constructor for objects of class Doctor
     */
    public Doctor()
    {
        // initialise instance variables
        potentialDis = new ArrayList<String>();
    }
    public static void main( String[] args)
    {
        Scanner s = new Scanner(System.out);
        System.out.println("Please enter a symptom: ");
        String symptom = s.next();
        updateDiseases(symptom);
        System.out.println("These are the potential diseases you might have");
        for ( String Disease: potentialDis[])
        {
            System.out.println(Disease);
        }
    }
    public void updateDiseases(String symptom)
    {
        // put your code here 
        Scanner in = new Scanner("Diseases.txt");
        in.useDelimiter("[^A-Za-z]+");
        
        
        // has next() in while loop
        
    }

}
//read file 