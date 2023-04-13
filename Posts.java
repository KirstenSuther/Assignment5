public class Posts
{
  public String title; //eg. More cats playing with wool
  public String video; //eg. video2.mpg
  public int likes; //eg. 75
  
  public Posts(String T, String V, int L )
  {
    title = T;
    video = V;
    likes = L;
  }
  
  //getters
  public String getTitle()
  {
    return title;
  }
  
  public int getlikes()
  {
    return likes;
  }
  
  public String getvideo()
  {
    return video;
  }
  
  //setters
  public void setTitle(String T)
  {
    title = T;
  }
  
  public void setlikes(int L)
  {
    likes = L;
  }
  
  public void setVideo(String D)
  {
    video = D;
  }
  
  //toString
  public String toString()
  {
    return "Title: " + title + "\n" + "Video: " + video + "\n" + "Number of likes: " + likes + "\n" ;
  }
  
}