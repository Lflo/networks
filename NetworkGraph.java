import java.io.Serializable;
import java.util.Iterator;

/* IMPLEMENTED & EDITED FROM PRAC 5 GRAPHS
    old name = DSAGraph()               */

public class NetworkGraph implements Serializable
{
    private DSALinkedList userList;
    private int userCount, followCount;
    public NetworkGraph()
    {
        userList = new DSALinkedList();
        userCount = 0;
        followCount = 0;
    }
    public void addUser(String user)
    {
        if(!hasUser(user))
        {
            User addUser = new User(user);
            userList.insertLast(addUser);
            userCount++;
        }
        else
        {
            throw new IllegalArgumentException("ERROR: user already exists");
        }
        
    }
    public void addFollower(String user1, String user2)
    {
        Iterator iter = userList.iterator();

        User sharer = null;
        User follower = null;
        User tmpUser = null;
        boolean src = false;
        boolean dest = false;
        
        if(!userList.isEmpty())
        {
            tmpUser = (User)iter.next();
        }
        while(tmpUser != null)
        {
            if(tmpUser.getUser().equals(user1))
            {
                src = true;
                sharer = tmpUser;
            }
            else if(tmpUser.getUser().equals(user2))
            {
                dest = true;
                follower = tmpUser;
            }
            tmpUser = (User)iter.next();
        }
        if (src && dest) 
        {
            if(!isFollowing(sharer, follower))
            {
                sharer.addFollower(follower);
                follower.addFollowing(sharer);
                followCount++;
            }
            else
            {
                throw new IllegalArgumentException("ERROR: " + follower.getUser() + " is already a follower of " + sharer.getUser());
            }
        }
        else if(!src || !dest)
        {
            throw new IllegalArgumentException("ERROR: " + user1 + " or " + user2 + " does not exist");
        }
    }

    public boolean hasUser(String user)
    {
        Iterator iter = userList.iterator();
        User tmpUser = null;
        boolean hasUser = false;

        while (iter.hasNext()) // vertex not already in list) 
        {
            // iterate through userList 
            tmpUser = (User)iter.next();
            if(tmpUser.getUser().equals(user))
            {
                hasUser = true;
            }
        }
        return hasUser;
    }
    public int getUserCount()
    {
        return userCount;
    }
    public int getfollowCount()
    {
        return followCount;
    }
    public DSALinkedList getUserList()
    {
        return userList;
    }
    public User getUser(String user)
    {
        User findUser = null;
        User tmpUser = null;
        Iterator iter = userList.iterator();

        while(iter.hasNext())
        {
            tmpUser = (User)iter.next();
            if(tmpUser.getUser().equals(user))
            {
                findUser = tmpUser;
            }
        }
        if(findUser == null)
        {
            throw new IllegalArgumentException("User-" + user + "does not exist");
        }
        
        return findUser;
    }
    public DSALinkedList getFollowers(String user)
    {
        User vertex = getUser(user);

        return vertex.getFollowers();
    }
    public boolean isFollowing(User sharer, User follower)
    {
        Iterator iter = sharer.getFollowers().iterator();
        boolean isFollowing = false;
        User tmpUser = null;

        if (!userList.isEmpty())
        {
            tmpUser = (User)iter.next();
        }

        while(tmpUser != null)
        {
            
            if(tmpUser.getUser().equals(follower.getUser()))
            {
                isFollowing = true;
            }

            tmpUser = (User)iter.next();
        }
        return isFollowing;
    }
    public String displayAsList()
    {
        Iterator iter = userList.iterator();
        String list = "";

        while(iter.hasNext())
        {
            list += (((User)iter.next()).toString() + "\n");
        }
        return list;
    }

    public String getRecord(String user)
    {
        return getUser(user).toRecord();
    }

    public String getRecord(User user)
    {
        return user.toRecord();
    }

    public String getAllRecords()
    {
        Iterator iter = userList.iterator();
        String outString = "";


        while(iter.hasNext())
        {
            outString += getRecord((User)iter.next()) + "\n\n";
        }

        return outString;
    }
    public void clearAllVisited()
    {
        Iterator iter = userList.iterator();

        while(iter.hasNext())
        {
            ((User)iter.next()).clearVisited();
        }
    }

}