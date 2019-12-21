/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab2;

/**
 *
 * @author Janeeta Zahid 
 * 500828574
 */
public class Palindrome {

//Requires: A string or null value

//Modifies: 

//Effects: if the string is a Palindrome then the palindrome function returns true and true is printed else false is printed 

public static boolean isPalindrome(String a) {

    if (a==null)
    {
        return false;
    }
    if(a.equals(""))
    {
        return false;
    }
    else 
        {
            String back=""; //Stroes the string backwards 
            for(int j=a.length()-1;j>=0;j--)
            {
                back=back+a.charAt(j); //gets character at that index
            }
            if(a.equals(back)) //check if the string backwards is equal to the original 
             {
                return true;
             }
            else 
               return false;
            
        }
            


}

public static void main(String[] args) {

    if(args.length == 1) 
        {

            if (args[0].equals("1"))
                System.out.println(isPalindrome(null));

            else if (args[0].equals("2"))
                 System.out.println(isPalindrome(""));

            else if (args[0].equals("3"))
                    System.out.println(isPalindrome("deed"));
            else if (args[0].equals("4"))
                    System.out.println(isPalindrome("abcd"));
        }

}


}



