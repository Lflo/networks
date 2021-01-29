import java.util.*;

public class SocialSim 
{
    public static void main(String args[]) 
    {
        try {
            Simulation sim = new Simulation();
            UserInterface menu = new UserInterface();
    
            if (args.length == 1) 
            {
                if (args[0].equals("-i")) 
                {
                    menu.InteractiveMenu();     
                }  
            }
            else if (args.length == 5)
            {
                if (args[0].equals("-s")) 
                {
                    sim.SimulationMode(args[1], args[2], args[3], args[4]);    
                }
            }
            else
            {
                System.out.println("USAGE:-\n" +
                    "   -i :    Interactive Mode\n" +
                    "       NetworkMain -i\n" +
                    "   -s :    Simulation Mode\n" +
                    "       NetworkMain -s networkfile eventfile prob_like prob_fail");
            }
        } catch (Exception e) 
        {
            throw new IllegalArgumentException("ERROR: incorrect usage of command-line " + e.getMessage());
        }
    }
}