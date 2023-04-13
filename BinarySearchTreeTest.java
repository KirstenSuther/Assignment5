// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman


import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class BinarySearchTreeTest
{
  
   public static void main ( String [] args )
   {
     
     Scanner keyboard = new Scanner(System.in);
     BinarySearchTree<Account> accounts = new BinarySearchTree<Account> ();
      
      
     //create a while loop to continuously ask the user to choose what they want to do until they quit
     int command = 0;
    
     do
     {
     System.out.println("Choose an action from the menu:");
     System.out.println("1. Find the profile description for a given account");
     System.out.println("2. List all accounts");
     System.out.println("3. Create an account");
     System.out.println("4. Delete an account");
     System.out.println("5. Display all posts for a single account");
     System.out.println("6. Add a new post for an account");
     System.out.println("7. Load a file of actions from disk and process this");
     System.out.println("8. Quit");
     System.out.print("Enter your choice: ");
     command = keyboard.nextInt();
     String redundant = keyboard.nextLine();
    
    
     switch (command)
     {
       case 1:
         //FIND PROFILE DECRIPTION FOR A GIVEN ACCOUNT
         System.out.print("Enter the account name: ");
         String Name = keyboard.nextLine();
         
         //create an Account with this name but with a blank space for the description to search for
         Account searchAccount = new Account(Name, "");
         BinaryTreeNode<Account> foundNode = accounts.find(searchAccount);
         Account foundAccount = foundNode.data;
         String description = foundAccount.description;
         System.out.println("The profile description is: " + description);
         
         break;
       case 2:
         //LIST ALL THE ACCOUNTS
         accounts.preOrder();
         break;
       case 3:
         //CREATE AN ACCOUNT
         //obtain account attributes
         System.out.println("Enter Account Name");
         String name = keyboard.nextLine();
         
         if (name.equals(""))
         {
           while (name.equals(""))
           {
             System.out.println("Enter Account Name");
             name = keyboard.nextLine();
           }
         }
         
         System.out.println("Enter Account Description");
         String Description = keyboard.nextLine();
         //create account
         Account newAccount = new Account(name, Description); 
         accounts.insert (newAccount); 
         
         //REMEMBER TO ADD A TEST TO MAKE SURE THAT THE NAME OF THE ACCOUNT AND THE ACCOUNT DESCRIPTION ISN'T EMPTY
         System.out.println("Account added successfully.");
         
         break;
       case 4:
         //DELETE AN ACCOUNT
         //first find the account
         System.out.print("Enter the account name: ");
         String NameD = keyboard.nextLine();
         
         //create an Account with this name but with a blank space for the description to search for
         Account searchAccountD = new Account(NameD, "");
         accounts.delete(searchAccountD); 
         
         System.out.println("Account deleted successfully.");
         

         break;
       case 5:
         //DISPLAY ALL THE POSTS FOR A SINGLE ACCOUNT
         //first find the account
         System.out.print("Enter the account name: ");
         String NameP = keyboard.nextLine();
         
         //create an Account with this name but with a blank space for the description to search for
         Account searchAccountP = new Account(NameP, "");
         BinaryTreeNode<Account> foundNodeP = accounts.find(searchAccountP);
         Account foundAccountP = foundNodeP.data;
         ArrayList<Posts> postList = foundAccountP.postList;
         
         //now that we have the list of posts for that account we can print the list. 
         //traverse through arraylist
         for (int index = 0; index < postList.size(); index++)
         {
           //access that Post object
           Posts currPost = postList.get(index);
           //print out toString method
           System.out.println(currPost.toString());           
         }
         break;
       case 6:
         //ADD A NEW POST FOR A PARTICULAR ACCOUNT
         System.out.println("Enter the title of post: ");
         String newPostTitle = keyboard.nextLine();
         System.out.println("Enter the name of the video: ");
         String newPostVideo = keyboard.nextLine();
         System.out.println("Enter the number of likes: ");
         int newPostLikes = keyboard.nextInt();
         //go onto the next line so the name can be entered properly
         String redundant2 = keyboard.nextLine();
         
         //create the post
         Posts newPost = new Posts(newPostTitle, newPostVideo, newPostLikes);
         //find the account that the post will be added to
         System.out.print("Enter the account name: ");
         String NameZ = keyboard.nextLine();
         
         //create an Account with this name but with a blank space for the description to search for
         Account searchAccountZ = new Account(NameZ, "");
         BinaryTreeNode<Account> foundNodeZ = accounts.find(searchAccountZ);
         Account foundAccountZ = foundNodeZ.data;
         ArrayList<Posts> accountPosts = foundAccountZ.postList;
         //add the post to the arrayList of Posts for that account
         accountPosts.add(newPost);
         break;
       case 7:
         //LOAD A FILE OF ACTIONS FROM DISK AND PROCESS THIS
         //user enters filename
         System.out.println("Enter textfile name");
         String textfile = keyboard.nextLine();
         
         Scanner inputStream = null;
         PrintWriter outputStream = null;
         
         try 
         {
           inputStream = new Scanner(new FileInputStream(textfile));          
         }
         catch (FileNotFoundException exception1)
         {
           System.out.println("Problem opening files.");
           System.exit(0);
         }

           //run through each line in textfile
           String line = null;
           while (inputStream.hasNextLine())
           {
             line = inputStream.nextLine();
             
             //check if the first command ("create" or "add")
             char space = ' ';
             int spaceIndex1 = line.indexOf(space);
             String fileCommand = line.substring(0, spaceIndex1);
             
             
             if (fileCommand.equals("Create") )
             {
               //CREATE ACCOUNT
               //obtain Account Name from string
               //find second space (account name is betweent the )
               int spaceIndex2 = line.indexOf(space, spaceIndex1 + 1);
               String fileAccName = line.substring(spaceIndex1 + 1, spaceIndex2);
               //obtain Account Description from string
               String fileAccDescription = line.substring(spaceIndex2 + 1, line.length() - 1);
               //add new account to binary tree  
               Account fileAccount = new Account(fileAccName, fileAccDescription); 
               accounts.insert (fileAccount);             
             }
             else if (fileCommand.equals("Add"))
             {
               //ADD POST TO ACCOUNT
               //ACCOUNT NAME
               //find second space (account name is between the first and second space is the Account Name )
               int spaceIndex2 = line.indexOf(space, spaceIndex1 + 1);
               String fileAccName2 = line.substring(spaceIndex1 + 1, spaceIndex2);
               //CREATE SEARCH ACCOUNT
               //create an account to search the binary tree for the posts relating to the specified account name
               Account A = new Account(fileAccName2, "");
                              
               //find post info in line
               //POST TITLE
               //find 3rd space (between the 2nd and 3rd space is the video Title)
               int spaceIndex3 = line.indexOf(space, spaceIndex2 + 1);
               String filePostVideo = line.substring(spaceIndex2 + 1, spaceIndex3);
               //POST LIKES
               //find 4rd space (between the 3rd and 4th space is the number of likes)
               int spaceIndex4 = line.indexOf(space, spaceIndex3 + 1);
               String filePostLikesS = line.substring(spaceIndex3 + 1, spaceIndex4);
               int filePostLikes = Integer.parseInt(filePostLikesS); 
               //POST VIDEO
               String filePostTitle = line.substring(spaceIndex4 + 1, line.length());
               //create post
               Posts filePost = new Posts(filePostTitle, filePostVideo, filePostLikes);
               //add post
               BinaryTreeNode<Account> foundNodeFile = accounts.find(A);
               Account foundAccountFile = foundNodeFile.data;
               ArrayList<Posts> fileAccountPosts = foundAccountFile.postList; 
               fileAccountPosts.add(filePost);
             }
           }

          
         
         //close textfile
         inputStream.close();
         break;
       default:
         System.out.println("Bye!");
         break;
     }
    
    
    
     } while (command != 8);

      
   }
}
