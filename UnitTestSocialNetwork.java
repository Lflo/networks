public class UnitTestSocialNetwork
{
	public static void main(String args[])
    {
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        SocialNetwork network;      
        NetworkGraph net = new NetworkGraph();  
        DSALinkedList posts = new DSALinkedList();
        //---------------------------------------------------------------------------

        System.out.println("\n\nTesting Normal Conditions - Constructor");
        System.out.println("=======================================");

        // TEST 1 : CONSTRUCTOR
        try {
            iNumTests++;
            network = new SocialNetwork();
            iNumPassed++;
            System.out.println("~~~ PASSED ~~~");
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting getNetwork");
            System.out.println("=======================================");
    
            // TEST 2: Get Network
            try {
                iNumTests++;
                network.getNetwork();
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting setNetwork");
            System.out.println("=======================================");
    
            // TEST 3: setNetwork
            try 
            {
                iNumTests++;
                network.setNetwork(net);
                System.out.println("~~~ PASSED ~~~"); 
                iNumPassed++;
            } 
            catch(Exception e) 
            { 
                System.out.println("~~~ FAILED ~~~");
            }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting addPost");
            System.out.println("=======================================");
    
            // TEST 4: Add post
            try {
                iNumTests++;
                System.out.println("Andy:Oh, yeah? Well, good riddance, ya loony!");
                net.addUser("Andy");
                network.addPost("Andy", "Oh, yeah? Well, good riddance, ya loony!", 1);
                posts.printList();
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~" + e.getMessage()); }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting getPosts");
            System.out.println("=======================================");
    
            // TEST 5: getPosts
            try {
                iNumTests++;
                posts = network.getPosts();
                posts.printList();
                System.out.println("~~~ PASSED ~~~"); 
                iNumPassed++;
            } 
            catch(Exception e)  {   System.out.println("~~~ FAILED ~~~");   }
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting findPost");
            System.out.println("=======================================");
    
            // TEST 6:  find posts""Oh, yeah? Well, good riddance, ya loony!"
            try {
                iNumTests++;
                String poster = network.findPost("Oh, yeah? Well, good riddance, ya loony!").toString();
                System.out.println(poster);
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting hasPOst");
            System.out.println("=======================================");
    
            // TEST 7: has post
            try {
                iNumTests++;
                network.hasPost("Oh, yeah? Well, good riddance, ya loony!");
                iNumPassed++;
                System.out.println("~~~ PASSED ~~~");
            } catch(Exception e) { System.out.println("~~~ FAILED ~~~"); }
    
            //---------------------------------------------------------------------------
    
            System.out.println("\nTesting getEvents");
            System.out.println("=======================================");
    
            // TEST 9: Display as List
            try {
                iNumTests++;
                //////////
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