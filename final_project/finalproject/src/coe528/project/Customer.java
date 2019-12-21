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
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
public class Customer extends User {
    String password;
    String username;
    String role= "Customer";    //role is always custormer 
    int accountnum;             //stores account number for each customer 
    Level level=new Silver();   //assuming every customer begins at the Silver level
    double balance;             //account balance of customer 
    String name;                //name of cutomer 
    //constructor
    Customer(String pass, String user,int num,double b,String n)
        {
            super(pass,user);
            accountnum=num;
            balance=b;
            name=n;
            level.changeLevel(this);
        }
    
    //method to login 

    @Override
    boolean Login(String pass,String user)
        {
        for (File bankfile : bankfiles) {
            if (bankfile.getName().equals(name)) {
                ArrayList<String> list = new ArrayList<>(); //this array lists stores all the Strings in the file   
                Scanner scanner = new Scanner(bankfile.getName()); //reads from the current file
                while(scanner.hasNextLine()) //while the file is not done
                {
                    list.add(scanner.nextLine()); //add to the list all the Strings
                }
                if(list.contains(pass)) //if the file contains the passowrd provided
                {
                    return true; //return true
                }
            }
        }
         return false; //else return false 
        }

     //setters and getters for Balnace 
    double getBalance ()
        {
             return balance;
        }
    void setBalance (double b)
        {
             balance=b;
        } 
    //setters and getters for level
    Level getLevel ()
        {
             return level;
        }
    void setLevel (Level l)
        {
             level=l;
        } 
    //setter and getter for name 
    String getName ()
        {
             return name;
        }
    void setName (String n)
        {
             name=n;
        } 
     //deposit money
    void Deposit(double m)
    {
       balance=balance+m;
       //check to see if the level changes 
       level.changeLevel(this);
    }
    //withdraw money
    void Withdraw (double m)
    {
       //not enough money to withdraw
      if(balance<m||balance==0)
      {
          throw new IllegalArgumentException("You are trying to withdraw more money than you have");
      }
      else
        {
            balance=balance-m;
            //check to see if level changed
            level.changeLevel(this);
        }
    }
   //online purchase
   void onlinePurchase(double m)
    {
        //purchase must be $50
        if(m<50.00)
            {
                throw new IllegalArgumentException("Sorry the online purchase must have value of atleast $50"); 
            }
        //if theres not enough money to make purchase
         if((level.fee)+m>balance||balance==0)
                {
                    throw new IllegalArgumentException("Sorry, You do not have enough money for this purchase");
                }
         //withdraw moeny and apply respective fee 
         else
            {
               if(level instanceof Silver)
                {
                    Withdraw(level.fee+m);
                }
               if(level instanceof Gold)
                 {
                    Withdraw(level.fee+m);
                 }
                if(level instanceof Silver)
                 {
                    Withdraw(m);
                 }
                level.changeLevel(this); //see if the level changes 
            }
        
    }
    @Override
    void Logout()
    {
        System.out.println("Thank you for visiting");
    }
           //setters and getters for username
    String getUsername ()
        {
             return Username;
        }
    void setUsername (String u)
        {
             Username=u;
        }
    //setters and getters for password 
    String getPassword ()
        {
             return password;
        }
    void setPassword (String p)
        {
             password=p;
        }
 
    /**
     *
     * @return
     */
    @Override 
   public String toString()
    {
            return("Username: "+getName()+"\n"+"Password: "+getPassword()+"\n"+"Current Balance: "+getBalance()+"\n");
    }
  
}
