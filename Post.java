public class Post
{
    private String poster;
    private String post;
    private int likes, cbFactor;

    public Post(String inPoster, String inPost)
    {
        poster = inPoster;
        post = inPost;
        likes = 0;
        cbFactor = 1; //default clickbait factor
    }

    public Post(String inPoster, String inPost, int inFactor)
    {
        poster = inPoster;
        post = inPost;
        likes = 0;
        cbFactor = inFactor;
    }

    public String getPoster() 
    {
        return poster;
    }

    public String getPost() 
    {
        return post;
    }

    public int getLikes()
    {
        return likes;
    }
    
    public void liked()
    {
        likes++;
    }
    
    public int getcbFactor()
    {
        return cbFactor;
    }
    
}