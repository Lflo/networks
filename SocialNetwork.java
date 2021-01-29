import java.util.*;
import java.time.*;

public class SocialNetwork
{
    private NetworkGraph network;
    private DSALinkedList posts;
    private DSALinkedList events;
    private DSALinkedList nextTimeStepList;
    private double prob_like;
    private double prob_foll;

    public SocialNetwork()
    {
        network = new NetworkGraph();
        posts = new DSALinkedList();
        events = new DSALinkedList();
        nextTimeStepList = new DSALinkedList();
        prob_like = 0.6; // default probabilities
        prob_foll = 0.5;
    }

    //Network
    public NetworkGraph getNetwork() 
    {
        return network;
    }
    public void setNetwork(NetworkGraph network) 
    {
        this.network = network;
    }

    // Post
    public DSALinkedList getPosts() 
    {
        return posts;
    }
    public void setPosts(DSALinkedList posts) 
    {
        this.posts = posts;
    }
    public void addPost(String poster, String post, int cbFactor) 
    {
        if(network.hasUser(poster))
        {
            Post newPost = new Post(poster, post, cbFactor);
            posts.insertLast(newPost);
            network.getUser(poster).addPost();
        }
        else
        {
            throw new IllegalArgumentException("ERROR: User " + poster + " does not exist.");
        }
    }
    public Post findPost(String post)
    {
        Iterator iter = posts.iterator();
        Post posts = null, tmpPost;
        boolean found = false;

        while(iter.hasNext())
        {
            tmpPost = (Post)iter.next();
            if(tmpPost.getPost().equals(post))
            {
                posts = tmpPost;
                found = true;
            }
        }
        if(found == false)
        {
            throw new IllegalArgumentException("ERROR: post- " + post + " does not exist.\n");
        }

        return posts;
    }
    public boolean hasPost(String post)
    {
        Iterator iter = posts.iterator();
        Post tmpPost;
        boolean has = false;

        while(iter.hasNext())
        {
            tmpPost = (Post)iter.next();
            if(tmpPost.getPost().equals(post))
            {
                has = true;
            }  
        }

        return has;
    }
    public int getPostCount()
    {
        return posts.getCount();
    }

    // EVENTSi
    public DSALinkedList getEvents() 
    {
        return events;
    }
    public void setEvents(DSALinkedList events) 
    {
        this.events = events;
    }
    public void addEvents(String event)
    {
        events.insertLast(event);
    }
    public boolean hasEvent(String event)
    {
        Iterator iter = events.iterator();
        String tmpEvent;
        boolean has = false;

        while(iter.hasNext())
        {
            tmpEvent = (String)iter.next();
            if(tmpEvent.equals(event))
            {
                has = true;
            }  
        }

        return has;
    }

    // LIKE PROBABILITY
    public double getProb_like() 
    {
        return prob_like;
    }
    public void setProb_like(double prob_like) 
    {
        this.prob_like = prob_like;
    }

    // FOLLOW PROBABILITY
    public double getProb_foll() 
    {
        return prob_foll;
    }
    public void setProb_foll(double prob_foll) 
    {
        this.prob_foll = prob_foll;
    }

    public void doEvent(String event)
    {
        String[] splitLine = event.split(":");
        char eventType = splitLine[0].charAt(0);
        if(eventType == 'A')
        {
            network.addUser(splitLine[1]);
        }
        else if(eventType == 'F')
        {
            if(network.hasUser(splitLine[1]))
            {
                if(network.hasUser(splitLine[2]))
                {
                    if(!network.isFollowing(network.getUser(splitLine[1]), network.getUser(splitLine[2])))
                    {
                        network.addFollower(splitLine[1],splitLine[2]);
                    }
                }
            }
            else
            {
                throw new IllegalArgumentException("ERROR: following user");
            }
        }
        else if(eventType == 'R')
        {
            System.out.println("ERROR: remove function not yet implemented");
        }
        else if(eventType == 'U')
        {
            System.out.println("ERROR: unfollow function not yet implemented");
        }
    }

    public boolean timeStep()
    {
        DSALinkedList nextTimeStep = new DSALinkedList();
        boolean step = true;
        Post post;

        if(nextTimeStepList.isEmpty())
        {
            String splitLine[] = eventToPost().split(":");
            if(splitLine.length == 1)
            {
                step = false;
            }
            else if(splitLine.length == 3 || splitLine.length == 4)
            {
                if(splitLine.length == 3)
                {
                    // normal cbfactor post
                    post = new Post(splitLine[1], splitLine[2]);
                }
                else
                {
                    // cbfactor post
                    int cbf = Integer.parseInt(splitLine[3]);
                    post = new Post(splitLine[1], splitLine[2], cbf);
                }

                network.clearAllVisited();
                Iterator iter = network.getUser(post.getPoster()).getFollowers().iterator();

                while(iter.hasNext())
                {
                    nextTimeStep.insertLast(iter.next());
                }

                posts.insertLast(post);
                network.getUser(post.getPoster()).addPost();
                network.getUser(post.getPoster()).setVisited();
            }
        }

        Post Nextpost = (Post)posts.peekLast();
        while(!nextTimeStepList.isEmpty())
        {
            nextTimeStep = dispUser(Nextpost, (User)nextTimeStepList.removeFirst(), nextTimeStep);
        }

        nextTimeStepList = nextTimeStep;

        
        return step;
    }
    public String eventToPost()
    {
        String event = "";
        if(getEvents().getCount() != 0)
        {
            try 
            {
                event = (String)events.removeFirst();
                
                do
                {
                    if(event.charAt(0) != 'P')
                    {
                        doEvent(event);
                    }
                } while (event.charAt(0) != 'P');
            } catch (NullPointerException e) 
            {
                System.out.println("ERROR" + e.getMessage());
            }
        }

        return event;
    }

    public DSALinkedList dispUser(Post post, User user, DSALinkedList nextTimeStep)
    {        
        double cbFactor = post.getcbFactor();
        double randNum = Math.random();

        if(user.getUser().equals(post.getPoster()))
        {
            user.setVisited();
        }

        if(!user.getVisited())
        {
            network.getUser(user.getUser()).setVisited();

            if(randNum < (prob_like * cbFactor))
            {
                Iterator iter = user.getFollowers().iterator();

                while(iter.hasNext())
                {
                    User tmpFollower = network.getUser(((User)iter.next()).getUser());
                    if(tmpFollower.getVisited() == false && !currStepList(tmpFollower))
                    {
                        nextTimeStep.insertLast(tmpFollower);
                    }
                }

                findPost(post.getPost()).liked();
                network.getUser(post.getPoster()).addLike();
                
                double randNum2 = Math.random();
                if(randNum2 < prob_foll) 
                {
                    if (!network.isFollowing(network.getUser(post.getPoster()), network.getUser(user.getUser()))) 
                    {
                        network.addFollower(post.getPoster(), user.getUser());
                    }
                }
            }
        }

        return nextTimeStep;
    }

    public boolean currStepList(User user)
    {
        boolean out = false;
        Iterator currList = nextTimeStepList.iterator();

        while(currList.hasNext())
        {
            if(((User)currList.next()).getUser().equals(user.getUser()))
            {
                out = true;
            }
        }

        return out;
    }

    public String timeStepOutput(int timeStepNum)
    {
        String output = "Timestep " + timeStepNum + "\n" + "\tPost: " + 
            ((Post)posts.peekLast()).getPost() + "\t Poster: " + ((Post)posts.peekLast()).getPoster() + "\n" +
                "\t\tTo be viewed by users:\n";
        System.out.println(((Post)posts.peekLast()).getPoster() +
            "\n\tTo be viewed by users:\n");
        
        if(!nextTimeStepList.isEmpty())
        {
            Iterator iter = nextTimeStepList.iterator();
            while(iter.hasNext())
            {
                output += "\t\t\t" + ((User)iter.next()).getUser() + "\n";
            }                                         
        }
        else
        {
            // indicate no users to view
            output += " ... \n";
        }

        output += network.displayAsList();
        output += network.getAllRecords();

        return output;
    }

}