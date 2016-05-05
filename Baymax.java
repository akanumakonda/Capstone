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

    public static void main( String[] args)
    {
        Baymax doc = new Baymax();
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
         narrowDown(s);
    }

    public static void updateDiseases(String symptom)
    {
        // put your code here 

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
    public static void narrowDown(Scanner s)
    {
        System.out.println("Are you experiencing any other symptoms?");
        String ans = s.next();
        if ( ans.contains("y"))
        {
            System.out.println("What is your other symptom?");
            String symp = s.next();
            for (int i = 0; i < potentialSymp.size(); i++)
            {
                if (symp.contains(symp) == false )
                {
                    potentialSymp.remove(i);
                }
            }
        }
    }
}
