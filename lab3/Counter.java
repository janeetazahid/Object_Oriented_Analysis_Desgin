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
public interface Counter {
   //The current value of this Counter as a String of digits.
   public String count();

   //Increment this Counter.
   public void increment();

   //Decrement this Counter.
   public void decrement();

   //Reset this Counter.
   public void reset();

}
