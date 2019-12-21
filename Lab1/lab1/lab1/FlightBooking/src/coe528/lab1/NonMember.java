/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author Janeeta Zahid
 */
public class NonMember extends Passenger {
    
     NonMember(String n,int a){
        super(n,a);
    }
    @Override 
    double applyDiscount(double p)
    {
        if(age>65)
            {
                return p*0.10;
            }
            return p;
    }
}
