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
public abstract class Passenger {
    String name;
    int age;
     Passenger (String n,int a)
    {
        name=n;
        age=a;
    }
    String getName()
    {
        return name;
    }
    int getAge()
    {
        return age;
    }
    void setName(String n)
    {
        name=n;
    }
     void setAge(int a)
    
    {
         age=a;
    }
    abstract double applyDiscount(double p);
    
    
}
