public class UnitTestSocialSim
{
	public static void main(String args[])
    {
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        Simulation sim = new Simulation();
        UserInterface menu = new UserInterface();
        SocialSim sSim = new SocialSim();
        //---------------------------------------------------------------------------
        
        
        try {
            System.out.println("\n\nTesting Normal Conditions - interactive");
            System.out.println("=======================================");
            
            // TEST 1 : interactive
            try {
                iNumTests++;
                String[] argss = {"-i"};
                SocialSim.main(argss);
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch (Exception e) { System.out.println("~~~~ FAILED ~~~");  }
            
            //---------------------------------------------------------------------------
            
            System.out.println("\nTesting simulation");
            System.out.println("=======================================");
    
            // TEST 2: Process Network
            try {
                iNumTests++;
                String[] aargs = {"-s", "ToyStoryNetwork.txt", "ToyStoryEvents1.txt", "0.6", "0.5"};
                SocialSim.main(aargs);
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