import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Exception;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private static ArrayList<String> potentialSymp;
    /**
     * Default constructor for objects of class Doctor
     */
    public Baymax()
    {
        // initialise instance variables
        potentialDis = new ArrayList<String>();
        potentialSymp = new ArrayList<String>();
    }


    /**
     * Main method that calls all other methods in class as needed
     *
     * @pre     All symptoms entered by user are spelled correctly
     * @post    Prints out all possible diseases that might result in the inputed symptoms
     */
    public static void main( String[] args)
    {
        Baymax doc = new Baymax();
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a symptom: ");
        String symptom = s.next();
        updateDiseases(symptom);
        printOut();
        narrowDown(s);
        printOut();
    }

    /**
     * Enters in all possible diseases the first symptom might be a result of
     *
     * @pre     Symptom is spelled correctly, with only one space between each word, and no punctuation
     * @post    Update the arrayList potentialDis 
     * @param   symptom   A String of the symptom
     */
    public static void updateDiseases(String symptom)
    {
        try
        {
            File listOfDiseases = new File("Diseases.txt");
            Scanner i = new Scanner(listOfDiseases);

            while ( i.hasNextLine())
            {
                String line = i.nextLine();
                if ( line.contains(symptom.toUpperCase()) == true)
                {
                    Scanner add = new Scanner(line);
                    String dis = add.next();
                    potentialDis.add(dis);
                    line.replace(dis, "");
                    potentialSymp.add(line);
                }
            }
            i.close();
        }
        catch (IOException e)
        {
            System.out.println("No File");
        }

    }
    
    /**
     * Narrows down the ArrayList potentialDis, uses userinput for additional symptoms
     *
     * @post    Deletes all diseases that do not result in the specified symptom
     * @param   s   A scanner object that reads user input

     */
    public static void narrowDown(Scanner s)
    {
        System.out.println("Are you experiencing any other symptoms?");
        String ans = s.next();
        while ( ans.contains("y"))
        {
            System.out.println("What is your other symptom?");
            String symp = s.next();
            for (int i = 0; i < potentialSymp.size(); i++)
            {
                if (symp.contains(symp.toUpperCase()) == false )
                {
                    potentialSymp.remove(i);
                    potentialDis.remove(i);
                }
            }
            System.out.println("Are you experiencing any other symptoms?");
            ans = s.next();
        }
    }
    
    /**
     *Prints out all Diseases in the ArrayListpotentialDis
     *
     * @pre     All instance variables are initialized
     * @post    All the potential diseases are printed out
     */
    public static void printOut()
    {
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
}
