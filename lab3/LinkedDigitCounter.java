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
public class LinkedDigitCounter extends AbstractCounter  {
  public  Counter leftNeighbor; //might refernce linkeddigit counter or digitcounter
    
    LinkedDigitCounter(Counter k)
    {
        super();
        leftNeighbor=k; //k is the next neighbour 
        
    }
   @Override
   public  String count() //return String 
   {
       String s=Integer.toString(count);
       return s;
   }
   @Override
   public  void increment()
   {
         if(count<9)
            {
                count++;
            }
         else 
            {
                if (this.leftNeighbor!=null) //if the left neighbur of te value is null dont do aything 
                {
                  this.count=0; //make it 0
                  leftNeighbor.increment(); //increment the left neighor  return ;
                }
                else 
                {
                    return; 
                }
            }  
       
       
   }
   @Override
   public  void decrement()
   {
       if(count>0)
       {
           count--;
       }
       else
       {
           count=9;
           leftNeighbor.decrement(); 
           //decrement digit to left 
       }
   }
   @Override
   public void reset()
   {
       count=0;
   }
    
    
}
