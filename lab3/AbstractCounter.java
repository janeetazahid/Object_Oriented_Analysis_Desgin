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
public abstract class AbstractCounter implements Counter {
   public  int count;
    @Override
   public abstract String count();
   @Override
   public abstract void increment();
   @Override
   public abstract void decrement();
   @Override
   public abstract void reset();
   public AbstractCounter()
   {
       count=0;
   }
   
   
    
}
