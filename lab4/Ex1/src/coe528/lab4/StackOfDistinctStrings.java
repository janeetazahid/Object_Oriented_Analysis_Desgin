/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab4;

/**
 *
 * @author Janeeta Zahid
 */
import java.util.ArrayList;
public class StackOfDistinctStrings {

    // Overview: StacksOfDistinctStrings are mutable, bounded    
    // collection of distinct strings that operate in 
    // LIFO (Last-In-First-Out) order. 
    //
    // The abstraction function is:
    //AF(c)=an abstract stack of strings S where top element of stack =c.items.top()
    //and adding to the stack is done by c.items.push() while removing is done by c.items.pop()
    // 
    // 
    // 
    //
    //
    // The rep invariant is: 
    //RI(c)=true if c.items[i]==a String for all 0<i<items.length()
    //and 
    // for all intergers i,j 
    // c.items.get(i)!=c.items.get(j) 
    //where 0<i,j<items.length() and i!=j (every string is unique )
    // =false otherwise 
    //

    //the rep
    private ArrayList<String> items;

    // constructor
    public StackOfDistinctStrings() {
        // EFFECTS: Creates a new StackOfDistinctStrings object
        items = new ArrayList<String>();
    }


    public void push(String element) throws Exception {
        // MODIFIES: this
        // EFFECTS: Appends the element at the top of the stack 
        //          if the element is not in the stack, otherwise
        //          does nothing.
        if(element == null) throw new Exception();
        if(false == items.contains(element)) 
            items.add(element);
    }


    public String pop() throws Exception {
        // MODIFIES: this
        // EFFECTS: Removes an element from the top of the stack 
        if (items.size() == 0) throw new Exception();
        return items.remove(items.size()-1);
    }
    


    public boolean repOK() 
    {
        // EFFECTS: Returns true if the rep invariant holds for this   
        //          object; otherwise returns false   
        String current="";
        if(items.isEmpty()) //stack cant be empty 
            {
                return false;
            }
        for(int i=0;i<=items.size()-1;i++) 
            {
                if (items.get(i) instanceof java.lang.String) //check if object is string
                    {
                        current=items.get(i); 
                    }
                else
                    {
                        return false; //if the object isnt a string return false 
                    }
                for(int j=i+1; j<=items.size()-1;j++)
		{
			if(items.get(j).equals(current)) //if the 2 strings are equal return false 
				{
					return false;
				}
		}


            }
        return true; 
    }  
    
    @Override
    public String toString() {
        // EFFECTS: Returns a string that contains the strings in the 
        //          stack and the top element. Implements the 
        //          abstraction function.  
        // 
           return ("AF(c)=c.items{i},where 0<=i<c.items.length()"+"also the pop method returns the top element"+"c.items.pop(),where top element =c.items.[length-1]");
            





    }
}


