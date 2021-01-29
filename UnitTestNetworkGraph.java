public class UnitTestNetworkGraph
{
	public static void main(String args[])
    {
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        NetworkGraph graph;
        
        //---------------------------------------------------------------------------

        System.out.println("\n\nTesting Normal Conditions - Constructor");
        System.out.println("=======================================");

        // TEST 1 : CONSTRUCTOR
        try {
            iNumTests++;
            graph = new NetworkGraph();
            iNumPassed++;
            System.out.println("~~~ PASSED ~~~");
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Add User");
            System.out.println("=======================================");
    
            // TEST 2: Add Users
            try {
                iNumTests++;
                graph.addUser("Andy");
                graph.addUser("Woody");
                graph.addUser("Mr. PotatoHead");
                graph.addUser("Hamm");
                graph.addUser("Lenny");
                System.out.println("Added Names (5) = " + graph.getUserCount());
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Duplicate Add: adding Woody");
            System.out.println("=======================================");
    
            // TEST 3: Duplicate, test whether user can be added twice (should fail)
            try 
            {
                iNumTests++;
                graph.addUser("Woody");
                System.out.println("~~~ FAILED ~~~");
            } 
            catch(Exception e) 
            { 
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~"); 
            }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting new Followers");
            System.out.println("=======================================");
    
            // TEST 4: Follower Adding
            try {
                iNumTests++;
                System.out.println("Hamm -> Andy, Mr. PotatoHead. Lenny -> Andy, Woody, Mr. PotatoHead -> Hamm");
                graph.addFollower("Andy", "Hamm");
                graph.addFollower("Andy", "Lenny");
                graph.addFollower("Woody", "Lenny");
                graph.addFollower("Hamm", "Mr. PotatoHead");
                graph.addFollower("Mr. PotatoHead", "Hamm");
                System.out.println("Added Follows (5) = " + graph.getfollowCount());
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting new follow to nonexisting user");
            System.out.println("=======================================");
    
            // TEST 5: Invalid Follower Add
            try {
                iNumTests++;
                graph.addFollower("Bo Peep", "Andy");
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
                System.out.println("Has Mr. PotatoHead: " + graph.hasUser("Mr. PotatoHead"));
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
                graph.getUser("Lenny");
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Display as List");
            System.out.println("=======================================");
    
            // TEST 9: Display as List
            try {
                iNumTests++;
                System.out.println(graph.displayAsList());
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