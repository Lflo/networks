 /***************************************************************************
 *  FILE: UnitTestLinkedList.java
 *  AUTHOR: Fraser Patten - 19480002
 *  PURPOSE: Basic Test Harness For Linked List
 *  LAST MOD: 30/10/19
 *  NOTE: PREVIOUSLY USED IN PRACTICALS
 ***************************************************************************/
import java.util.*;

 public class UnitTestLinkedList
{
	public static void main(String args[])
    {
        // VARIABLE DECLARATIONS
        int iNumPassed = 0;
        int iNumTests = 0;
        DSALinkedList ll = null;
        String sTestString;
        Object nodeValue;

        //---------------------------------------------------------------------------

        System.out.println("\n\nTesting Normal Conditions - Constructor");
        System.out.println("=======================================");
        
        // TEST 1 : CONSTRUCTOR
        try {
            iNumTests++;
            ll = new DSALinkedList();
            System.out.print("Testing creation of DSALinkedListDouble (isEmpty()): ");
            if (ll.isEmpty() == false)
            throw new IllegalArgumentException("Head must be null.");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }
        
        //---------------------------------------------------------------------------
        
        System.out.println("\nTest inserting first and removing first (stack behaviour)");
        System.out.println("==========================================================");
        
        try {
            iNumTests++;
            System.out.print("Testing insertLast(): ");
            ll.insertLast("abc");
            ll.insertLast("jkl");
            ll.insertLast("xyz");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }
        /*
        // TEST 20 : removeNode
        try {
            iNumTests++;
            System.out.print("Testing removeNode (): ");
            ll.removeNode("jkl");
            System.out.println("passesd");
        } catch(Exception e) { iNumPassed++; System.out.println("failed"); }
        */

        // TEST 3 : PEEK LAST
        try {
            iNumTests++;
            System.out.print("Testing peekLast(): ");
            sTestString = (String)ll.peekLast();
            if (sTestString != "xyz")
                throw new IllegalArgumentException("FAILED.");
            iNumPassed++;
            System.out.println("passed   ");
        } catch(Exception e) { System.out.println("FAILED"); }

        // TEST 4 : REMOVE FIRST
        try {
            iNumTests++;
            System.out.print("Testing removeFirst(): ");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "xyz")
                throw new IllegalArgumentException("FAILED.");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "jkl")
                throw new IllegalArgumentException("FAILED.");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "abc")
                throw new IllegalArgumentException("FAILED.");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println(e.getMessage()); }

        // TEST 5 : IS EMPTY
        try {
            iNumTests++;
            System.out.print("Testing isEmpty(): ");
            sTestString = (String)ll.removeFirst();
            System.out.println("FAILED");
        } catch(Exception e) { iNumPassed++; System.out.println("passed"); }

//---------------------------------------------------------------------------

        System.out.println("\nTest inserting last and removing first (queue behaviour)");
        System.out.println("========================================================");

        // TEST 6 : INSERT LAST()
        try {
            iNumTests++;
            System.out.print("Testing insertLast(): ");
            ll.insertLast("abc");
            ll.insertLast("jkl");
            ll.insertLast("xyz");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println("FAILED"); }
            


        // TEST 8 : REMOVE FIRST
        try {
            iNumTests++;
            System.out.print("Testing removeFirst(): ");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "abc")
                throw new IllegalArgumentException("FAILED. 1");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "jkl")
                throw new IllegalArgumentException("FAILED. 2");
            sTestString = (String)ll.removeFirst();
            if (sTestString != "xyz")
                throw new IllegalArgumentException("FAILED. 3");
            iNumPassed++;
            System.out.println("passed");
        } catch(Exception e) { System.out.println(e.getMessage()); }

        // TEST 9 : IS EMPTY 2
        try {
            iNumTests++;
            System.out.print("Testing isEmpty(): ");
            sTestString = (String)ll.removeFirst();
            System.out.println("FAILED");
        } catch(Exception e) { iNumPassed++; System.out.println("passed"); }

    //---------------------------------------------------------------------------

    System.out.println("\nTest Iteration");
    System.out.println("========================================================");

        // TEST 11 : ITERATE NEXT
        try
        {
            iNumTests++;
            System.out.print("Testing iterator: ");
            String[] inputs = {"abc", "jkl", "xyz"};
            
            ll.insertLast(inputs[0]);
            ll.insertLast(inputs[1]);
            ll.insertLast(inputs[2]);

            Iterator iter = ll.iterator(); 
            int ii = 0;
            while(iter.hasNext())
            {
                String value = iter.next().toString();
                assert value.equals(inputs[ii]) : " iterated value not equal ";
                ii++;
            }
            iNumPassed++;
            System.out.println("passed");
        }
        catch(Exception e) { System.out.println("FAILED"); }
        
    //---------------------------------------------------------------------------

        // PRINT TEST SUMMARY
        System.out.print("\nNumber PASSED: " + iNumPassed + "/" + iNumTests);
        System.out.print(" -> " + (int)(double)iNumPassed/iNumTests*100 + "%\n");
    
    //--------------------------------------------------------------------------- */
    }   
}