/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Janeeta Zahid
 */
import java.io.File;
import java.io.IOException; 
import java.util.ArrayList;
import java.io.FileWriter;
public class Manager extends User {
    String password;
    String username;
    String role= "Manager";             //role is always manager
    //OVERVIEW: A manager object has the ability to login, logout, add a customer and delete a customer
    // the manager object is immutable
    //
    //The Abstraction function is\;
    //AF(c)= an abstract manager object m where m.username=username of the manager
    // m.password=the managers password and m.role is always equal to "Manager"\
    // the method m.login() validates the managers login, m.addCustomer() allows the manager to add a customer 
    //m.deleteCustomer() allows the manager to delete a customer 
    //
    //
    //The rep invariant is:
    // RI(c)= true if c.password!=null and c.username!=null and c.role=="Manager"
    //
    //EFFECTS: creates a new Manager object
    //constructor
    Manager(String pass, String user)
        {
            super(pass,user);
        }
    //method to login 
    //Requires: A password of type string and a username of type string 
    //Effects: Returns true if the given password and username is equal to the username and password of the manager
    //Modifies:
    @Override
    boolean Login(String pass,String user)
        {
            if(password.equals(pass)&&user.equals(username)&&role.equals("Manager"))
            {
                return true;
            }
          return false;
        }
    //add customer
    //Requires: A password of type string, a username of type string, a account number of type int, a balance of type double and a name of type string 
    //Effects: if the user file doesn't already exsist, it creats a new file, with the file name as the custmers username, and adds it to the array list which stores all the files of the customers
    //Modifies: bankfiles arraylist and creates a new customer file in the directory 
    void addCustomer(String p,String u,int num,double b,String n)
        {   
            if(b<100)
            {
                System.out.println("Please Ensure the initial balance is $100 or more"); //manager must put an initail balance of $100 in the customers account
            }
            else 
                {
                    Customer c = new Customer (p,u,num,b,n);
                       try{
                            File f=new File(c.username); //creates a new file with the title as the username of the customer
                            if(f.createNewFile()) //will return true if the file is sucessfully created and false if the file already exsists 
                            {
                                bankfiles.add(f); //adds the file to the array list 
                                System.out.println("Sucessfully created a new file for the customer");
                                FileWriter writer = new FileWriter(f.getName());
                                writer.write(c.toString()); //write the toString method of the customer into the file, this method contians the information about the customer
                            } else 
                                {
                                   System.out.println("Sorry this customer already exsists");//file already exsists 
                                }
                       }
                       catch(IOException e)
                        {
                           System.out.println("Error please try again");
                           e.printStackTrace(); //print where the error has occured 

                        }
               
                }
        }
 
    //delete customer 
    //Requires: an object of type Customer
    //Effects: removes the assoicaited file of the customer from the array list and deletes it 
    //Modifies: bankfiles arraylist and deletes the customer file in the directory 
    void deleteCustomer(Customer c)
        {
            for(int i=0;i<bankfiles.size();i++)
                {
                  if((c.username).equals(bankfiles.get(i).getName())) //check to find the apprpraite file to delete  
                    {
                           bankfiles.remove(i); //remove the file from the arrya list
                           File f2=new File(c.username);
                           f2.delete(); //delete the assocaited file 
                    }
                }
                   
        }
    
    public boolean repOK()
        {
            //EFFECTS: returns true if the rep invariant holds for the object
            //otherwise false
            if (username.isEmpty()||password.isEmpty()||(!(role.equals("Manager"))))
            {
                return false; //will only return false if the username is null or the password is null or the role is not equal to manager
            }
          return true;
        }
    @Override
    //logs the user out
     //Requires: 
    //Effects: logs the user out 
    //Modifies:  
    void Logout()
    {
        System.out.println("Thank you for visiting");
    }
    @Override
    public String toString()
    {
       //Effects: Returns a string that implements the abstraction function
        return("AF(c)=the username of the manager is c.username "+"the password of the manager is c.password "+"and the role of the manager is c.role");
    }
}
