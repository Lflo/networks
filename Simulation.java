public class Simulation
{
    private FileIO fileio;
    private SocialNetwork network;
    
    public Simulation()
    {
        network = new SocialNetwork();
        fileio = new FileIO();
    }
    
    public void SimulationMode(String netfile, String eventfile, String prob_like, String prob_foll)
    {
        try 
        {
            network = fileio.loadFile(network, netfile, "network");
            network = fileio.loadFile(network, eventfile, "events");
            setProbLike(prob_like);
            setProbFollow(prob_foll);
            //int sum = 0;
            //long totaltime = 0;
            //for (int j = 0; j < 10; j++)
            //{
                //long startTime = System.currentTimeMillis();
                
                // send to loadfile for processing -- see documentation for logic
                boolean step = true;
                String output = "";
                int i = 1;
                
                //network = new SocialNetwork();

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
                //long endtime = System.currentTimeMillis();
                //sum += ((Post)network.getPosts().peekLast()).getLikes();
                //totaltime += endtime - startTime;
            //}
            //System.out.println(totaltime/10);
            //System.out.println(sum/10);
            fileio.saveFile(output);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println(e.getMessage());
        }
    }

    public void setProbLike(String prob_like)
    {
        double probLike = Double.parseDouble(prob_like);
        if(probLike >= 0.0 && probLike <= 1.0)
        {
            network.setProb_like(probLike);
        }
        else
        {
            throw new IllegalArgumentException("ERROR: Like probability must be between 0.0-1.0");
        }
    }

    public void setProbFollow(String prob_foll)
    {
        double probfollow = Double.parseDouble(prob_foll);
        if(probfollow >= 0.0 && probfollow <= 1.0)
        {
            network.setProb_foll(probfollow);
        }
        else
        {
            throw new IllegalArgumentException("ERROR: Like probability must be between 0.0-1.0");
        }
    }
}