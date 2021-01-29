public class UnitTestFileIO
{
	public static void main(String args[])
    {
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        SocialNetwork network = new SocialNetwork();
        NetworkGraph graph = new NetworkGraph();
        FileIO file = new FileIO();
        
        //---------------------------------------------------------------------------

        
        try {
            System.out.println("\n\nTesting Normal Conditions - load file NETWORK");
            System.out.println("=======================================");

            // TEST 1 : Load File
            try {
                iNumTests++;
                file.loadFile(network, "ToyStoryNetwork.txt", "network");
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch (Exception e) { System.out.println("~~~~ FAILED ~~~");  }
            
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Process Network: line9 Woody:Hamm");
            System.out.println("=======================================");
    
            // TEST 2: Process Network
            try {
                iNumTests++;
                file.processNetwork("Woody:Hamm", network, 9);
                network.getNetwork().displayAsList();
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
            System.out.println("\n\nTesting Normal Conditions - load file EVENTS");
            System.out.println("=======================================");

            // TEST 1 : Load File
            try {
                iNumTests++;
                file.loadFile(network, "ToyStoryEvents1.txt", "events");
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch (Exception e) { System.out.println("~~~~ FAILED ~~~");  }

             //---------------------------------------------------------------------------
    
            System.out.println("\nTesting Process Events: line27");
            System.out.println("=======================================");
    
            // TEST 2: Process Network
            try {
                iNumTests++;
                file.processNetwork("P:Woody:BUZZ, LOOK, AN ALIEN!", network, 27);
                network.getNetwork().displayAsList();
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