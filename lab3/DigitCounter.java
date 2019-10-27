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
public class DigitCounter extends AbstractCounter {
   //public int count;
   DigitCounter()
   {
       super();
   }
   @Override
   public  String count() //works
   {
     String s=Integer.toString(count);
     return s;  
   }
   @Override
   public void increment()
   {
         if(count<9)
            {
                count++;
            }
         else 
            {
                throw new IndexOutOfBoundsException ("you tried to increment the last counter passed 9");
            }  
   }
   @Override
   public void decrement()
   {
         if(count>0)
       {
           count--;
       }
       else
       {
           count=9;
           
       }
   }
   @Override
   public  void reset()
   {
       {
       count=0;
   }
   }
    
}
