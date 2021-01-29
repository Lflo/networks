import java.util.*;
import java.io.*;

public class User
{
    private String User;
    private DSALinkedList followers, following;
    private boolean visited;
    private int likes, posts;
    
    public User(String inUser)
    {
        User = inUser;
        followers = new DSALinkedList();
        following = new DSALinkedList();
        visited = false;
        likes = 0;
        posts = 0;
    }

    public String getUser()
    {
        return User;
    }

    public DSALinkedList getFollowers()
    {
        return followers;
    }

    public DSALinkedList getFollowing()
    {
        return following;
    }

    public int getLikeCount()
    {
        return likes;
    }
    
    public int getPostCount()
    {
        return posts;
    }

    public boolean getVisited()
    {
        return visited;
    }

    public void addFollower(User newUser)
    {
        followers.insertLast(newUser);
    }

    public void addFollowing(User newUser)
    {
        following.insertLast(newUser);
    }

    public void setVisited()
    {
        visited = true;
    }

    public void clearVisited()
    {
        visited = false;
    }

    public String toString()
    {
        // iterates through followers list to print the user then who follows them
        // adapted from DSALinkedList toString() + iterateoverlist()
        Iterator iter = followers.iterator();
        String adjList = User + ": ";

        while(iter.hasNext())
        {
            adjList += ((User)iter.next()).getUser()+ " ";
        }

        return adjList;
    }

    public int getFollowerCount()
    {
        return getFollowers().getCount();
    }

    public int getFollowingCount()
    {
        return getFollowing().getCount();
    }

    public String toRecord()
    {
        String record = "User: " + getUser() + "\n" +
                        "    Number of Posts: " + getPostCount() + 
                        "    Number of Likes: " + getLikeCount() + " " +
                        "    Number of Followers: " + getFollowerCount() + " " +
                        "    Number of Following: " + getFollowingCount();
        return record;   
    }

    public void addLike()
    {
        likes++;
    }

    public void addPost()
    {
        posts++;
    }
}