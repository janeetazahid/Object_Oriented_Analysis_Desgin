/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab3;

/**
 *
 * @author Janeeta Zahid
 */

import java.util.LinkedList;
public class Odometer implements Counter
{
    public int num;
    LinkedList<LinkedDigitCounter> odo=new LinkedList<>();
    Odometer (int n)
    {
        num=n;
        if(num<1)
        {
            throw new IllegalArgumentException("The number of instances must be greater than 1");  
        }
       //initalize the counter array 
       for (int j=0; j<num; j++)
         {
               LinkedDigitCounter r= new LinkedDigitCounter(null); //creates a new linked digit counter 
               odo.add(r); 
         }
       //initalize the left neighbors
       for(int k=0;k<num-1;k++)
       {
            
           odo.get(k).leftNeighbor=odo.get(k+1); //the leftneighbour is the next object
           
       }
       odo.get(num-1).leftNeighbor=null; //this will set the left most counters left neighbour to be null
        
    }

    /**
     *
     * @return
     */
    @Override
   public String count() //prints value of counter  
   {
       String s="";
       for(int i=num-1;i>=0;i--)
       {
           s=s+odo.get(i).count()+" ";
       }
      return s;
   }

  //Increment this Counter
   @Override
   public void increment() 
   {
     
         if(odo.get(num-1).count==9) //if the counter is all 9s then it will reset to 0
         {
             reset(); 
         }
         else 
         {
             
             odo.get(0).increment(); //or else start incrementing 
         }
         
     
     }
       
   

   //Decrement this Counter.
    @Override
   public void decrement()
   {
       boolean allzero=true; 
       
          for (int j=0;j<num;j++) 
          {
              if (odo.get(j).count!=0) //figuring out if the counter is all 0s
              {
                  allzero=false; 
              }
          }
          if(allzero==true) 
          {
              allnine(); //if all zeros turn to all 9s
          }
          else 
          {
             odo.get(0).decrement(); //else start decrementing 
          }
           
       
   }

   //Reset this Counter.
    @Override
   public void reset() 
   {
     for(int j=0;j<num;j++)
     {
         odo.get(j).count=0; 
     }
     
   }
   public void allnine()
   {
       for(int h=0;h<num;h++)
       {
           odo.get(h).count=9;
       }
   }
}
