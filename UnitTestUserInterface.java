import java.util.*;
import java.io.*;

public class UnitTestUserInterface
{
	public static void main(String args[])
    {
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        UserInterface user;
        user = new UserInterface();
        SocialNetwork network;
        FileIO fileio;
        
        //---------------------------------------------------------------------------

        System.out.println("\n\nTesting Normal Conditions - Constructor");
        System.out.println("=======================================");

        // TEST 1 : CONSTRUCTOR
        try {
            iNumTests++;
            network = new SocialNetwork();
            fileio = new FileIO();
            iNumPassed++;
            System.out.println("~~~ PASSED ~~~");
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Load Network");
            System.out.println("=======================================");
    
            // TEST 2: Add Users
            try {
                iNumTests++;
                user.loadNetwork();
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Set Probabilities: ");
            System.out.println("=======================================");
    
            // TEST 3: Duplicate, test whether user can be added twice (should fail)
            try 
            {
                iNumTests++;
                user.setProbabilities2();
                System.out.println("~~~ PASSED ~~~"); 
                iNumPassed++;
            } 
            catch(Exception e) 
            { 
                System.out.println("~~~ FAILED ~~~");
            }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting new Followers");
            System.out.println("=======================================");
    
            // TEST 4: Follower Adding
            try {
                iNumTests++;
                System.out.println("Hamm -> Andy, Mr. PotatoHead. Lenny -> Andy, Woody, Mr. PotatoHead -> Hamm");
                network.getNetwork().addFollower("Andy", "Hamm");
                System.out.println("01");
                network.getNetwork().addFollower("Andy", "Lenny");
                System.out.println("02");
                network.getNetwork().addFollower("Woody", "Lenny");
                System.out.println("03");
                network.getNetwork().addFollower("Hamm", "Mr. PotatoHead");
                System.out.println("04");
                network.getNetwork().addFollower("Mr. PotatoHead", "Hamm");
                System.out.println("05");
                System.out.println("Added Follows (5) = " + network.getNetwork().getfollowCount());
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting new follow to nonexisting user");
            System.out.println("=======================================");
    
            // TEST 5: Invalid Follower Add
            try {
                iNumTests++;
                network.getNetwork().addFollower("Bo Peep", "Andy");
                System.out.println("~~~ FAILED ~~~");
            } 
            catch(Exception e) 
            { 
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~"); 
            }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Has User");
            System.out.println("=======================================");
    
            // TEST 6: Has User
            try {
                iNumTests++;
                System.out.println("Has Mr. PotatoHead: " + network.getNetwork().hasUser("Mr. PotatoHead"));
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Get User");
            System.out.println("=======================================");
    
            // TEST 7: Get User
            try {
                iNumTests++;
                System.out.println("Get Users Lenny");
                System.out.println(network.getNetwork().getUser("Lenny"));
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
        
        } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
        //---------------------------------------------------------------------------

        // PRINT TEST SUMMARY
        System.out.print("\nNumber PASSED : " + iNumPassed + "/" + iNumTests);
        System.out.print(" -> " + (int)(((double)iNumPassed)/(iNumTests))*100 + "%\n");
    
        //---------------------------------------------------------------------------
    }
}