import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.lang.Exception;
import java.io.FileNotFoundException;
/**
 * Write a description of class Doctor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baymax
{
    /** description of instance variable x (add comment for each instance variable) */

    private static ArrayList<String> potentialDis;
    /**
     * Default constructor for objects of class Doctor
     */
    public Baymax()
    {
        // initialise instance variables
        potentialDis = new ArrayList<String>();
    } 

    public static void main( String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a symptom: ");
        String symptom = s.next();
        updateDiseases(symptom);
        try{
            System.out.println("These are the Potential Diseases you might have");
            for ( String Disease: potentialDis)
            {
                System.out.println(Disease);
            }
        }
        catch (Exception NullPointerException)
        {
            System.out.println("You have no Potential Diseases");
        }
    }

    public static void updateDiseases(String symptom)
    {
        // put your code here 
        File listOfDiseases = new File("Diseases.txt");
        try
        {
            Scanner i = new Scanner(listOfDiseases);

            while ( i.hasNextLine())
            {
                String line = i.nextLine();
                if ( line.contains(symptom.toUpperCase()) == true)
                {
                    Scanner getDisease = new Scanner(line);
                    potentialDis.add(getDisease.next());
                }
            }
            i.close();
        }
        catch (Exception FileNotFoundException)
        {System.out.println("No File");}
        // has next() in while loop

    }
}
