import java.util.*;
import java.io.*;

public class UserInterface
{
    private SocialNetwork network;
    private FileIO fileio;

    public UserInterface()
    {
        network = new SocialNetwork();
        fileio = new FileIO();
    }
    public void InteractiveMenu()
    {
        int choice, i = 1;
        boolean step = true;
        String output = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please select one of the following options\n" +
                "   1.  Load Network\n" +
                "   2.  Set Probabilities\n" + 
                "   3.  Node Operations\n" +
                "   4.  Edge Operations\n" + 
                "   5.  New Post\n" +
                "   6.  Display Network\n" +
                "   7.  Display Statistics\n" +
                "   8.  Update (run a timestep)\n" +
                "   9.  Save Network\n" +
                "   10. Exit\n");
            choice = sc.nextInt();
            
            switch (choice) 
            {
                case 1:
                    loadNetwork();
                    break;
                case 2:
                    setProbabilities2();
                    break;
                case 3:
                    nodeOperations3();
                    break;
                case 4:
                    EdgeOperations();
                    break;
                case 5:
                    newPost();
                    break;
                case 6:
                    System.out.println(network.getNetwork().displayAsList());
                    break;
                case 7:
                    System.out.println(network.getNetwork().getAllRecords());
                    break;
                case 8:
                    while (step) 
                    {
                        try {
                            step = network.timeStep();
                            output += network.timeStepOutput(i);
                            System.out.println(output);
                            i++;
                        } catch (Exception e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                    break;
                case 9:
                    fileio.saveFile(output);
                    break;
                case 10:
                    System.out.println("You have selected to exit. Goodbye!\n");
                    break;
                default:
                    System.out.println("ERROR: You have not selected a valid menu option");
                    break;
            }

        } while (choice != 10);

    }

    // menu option 1
    public void loadNetwork()
    {
        // assuming loading a network from a file not creating a new network
        Scanner sc = new Scanner(System.in);
        String netfile;
        int choice;

        try {
            System.out.println("Would you like to:- \n" +
                "   1.  load a network\n" +
                "   2.  Exit - return to main menu");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                    System.out.println("Enter a file name to load: ");
                    netfile = sc.nextLine();
                    network = fileio.loadFile(network, netfile, "network");
                    System.out.println("File loaded: " + netfile + "\n");
                    break;
                case 2:
                    System.out.println("You have selected to exit... returning to menu.");
                    break;
                default:
                    System.out.println("ERROR: you have not selected a valid response");
                    break;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // menu option 2
    public void setProbabilities2()
    {
        double likeProb = 0.0;
        double follProb = 0.0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a probability between 0.0-1.0 for likes");
            likeProb = sc.nextDouble();
            if (0.0 > likeProb || likeProb > 1.0) 
            {
                throw new IllegalArgumentException("ERROR: probability is not within range");    
            }
            network.setProb_like(likeProb);
            System.out.println("Enter a probability between 0.0-1.0 for follows");
            follProb = sc.nextDouble();
            if (0.0 > follProb || follProb > 1.0) 
            {
                throw new IllegalArgumentException("ERROR: probability is not within range");    
            }
            network.setProb_foll(follProb);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR: cannot set probabilities");
        }
    }
    
    // menu option 3
    public void nodeOperations3()
    {
        int choice;
        Scanner sc = new Scanner(System.in);
        do 
        {
            System.out.println("Would you like to:- \n" +
            "   1.  Find a User\n" + 
                "   2.  Create a new user\n" +
                "   3.  Remove a user\n" +
                "   4.  Exit - return to main menu");
                choice = sc.nextInt();
            sc.nextLine(); //clear buffer
            switch (choice) 
            {
                case 1:     
                    System.out.println("Enter the user you would like to find.\n");
                    String userName = sc.nextLine();
                    network.getNetwork().getUser(userName);
                    
                    break;
                    case 2:
                    System.out.println("Enter a user to add.\n");
                    String user = sc.nextLine();
                    network.getNetwork().addUser(user);
                    break;
                case 3:
                    System.out.println("deleting user not yet implemented");
                    break;
                    case 4: 
                    System.out.println("You have selected to exit. \nReturning to main menu...");
                    break;
                    default:
                    System.out.println("You have not selected a valid option. \nPlease try again");
                    break;
            }
        } while (choice != 4);
    }

    // menu option 4
    void EdgeOperations()
    {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Would you like to:- \n" +
                "   1. Follow a user\n" +
                "   2. Unfollow a user\n" +
                "   3. Exit - return to main menu.\n");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                    System.out.println("Enter a user to follow.\n");
                    String sharer = sc.nextLine();
                    System.out.println("Enter the user who is following " + sharer + "\n");
                    String follower = sc.nextLine();
                    network.getNetwork().addFollower(sharer, follower);
                    break;
                case 2:
                    System.out.println("unfollow is not yet implemented");
                    break;
                case 4: 
                    System.out.println("You have selected to exit. \nReturning to main menu...");
                    break;
                default:
                    System.out.println("You have not selected a valid option. \nPlease try again");
                    break;
            }
        } while (choice != 3);
    }

    //menu option (5)
    public void newPost()
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the user you would like to make a post.\n");
            String user = sc.nextLine();
            System.out.println("Enter the post you would like " + user + ", to make.\n");
            String post = sc.nextLine();
            network.addPost(user, post, 1);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid post attempt. " + e.getMessage());
        }
    }
}