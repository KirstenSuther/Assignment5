import java.util.ArrayList;

public class Account implements Comparable<Account>
{
  public String name;
  public String description;
  //ArrayList of Posts objects added to a particular account
  public ArrayList<Posts> postList ; 
  
  public Account(String Name, String Description)
  {
    name = Name;
    description = Description; 
    postList = new ArrayList<>();  //initialise a new Account to having no posts by default 
  }
  
  public int compareTo(Account another)
  {
    return name.compareTo(another.name);
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public ArrayList<Posts> getPostList()
  {
    return postList;  
  }
  
  //setters
    public void setName(String N)
  {
    name = N;
  }
  
  public void setDescription(String D)
  {
    description = D;
  }
  
  //ADD POST TO A PARTICULAR ACCOUNT
  public void addPost(Posts post)
  {
    postList.add(post);
  }
  
  public String toString()
  {
    //print out the name and user description
    return "Account name: " + name + "\n" + name + "'s account description: " + description;
  }
}