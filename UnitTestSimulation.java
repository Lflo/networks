public class UnitTestSimulation
{
	public static void main(String args[])
    {
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        Simulation sim = new Simulation();
        SocialNetwork network = new SocialNetwork();
        
        //---------------------------------------------------------------------------
        
        
        try {
            System.out.println("\n\nTesting Normal Conditions - Constructor");
            System.out.println("=======================================");
            
            // TEST 1 : Constructor
            try {
                iNumTests++;
                sim = new Simulation();
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch (Exception e) { System.out.println("~~~~ FAILED ~~~");  }
            
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Simulation Mode");
            System.out.println("=======================================");
    
            // TEST 2: Simulation mode
            try {
                iNumTests++;
                sim.SimulationMode("ToyStoryNetwork.txt", "ToyStoryEvents1.txt", "0.6", "0.4");
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
            System.out.println("\n\nTesting Normal Conditions - setProbLike");
            System.out.println("=======================================");

            // TEST 1 : set like probability
            try {
                iNumTests++;
                sim.setProbLike("0.6");
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch (Exception e) { System.out.println("~~~~ FAILED ~~~");  }

             //---------------------------------------------------------------------------
    
            System.out.println("\nTesting setProbFollow");
            System.out.println("=======================================");
    
            // TEST 2: set follow probability
            try {
                iNumTests++;
                sim.setProbFollow("0.4");
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