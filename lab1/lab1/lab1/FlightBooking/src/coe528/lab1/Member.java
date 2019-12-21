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
public class Member extends Passenger{
    
    int yearsOfMembership;
    //constructor using superclasses constructor while adding the years of membership
    Member(String n,int a,int y){
        super(n,a);
        yearsOfMembership=y;
    }
    @Override
    double applyDiscount(double p)
    {
        if(yearsOfMembership>5)
            {
                return p*0.5;
            }
        if(yearsOfMembership>1&&yearsOfMembership<=5)
            {
                return p*0.10;
            }
        else 
            {
                return p;   
            }
    }
}
