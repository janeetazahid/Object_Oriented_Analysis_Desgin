/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Janeeta Zahid
 */
public abstract class Level {
    int fee;
    Level leveltype;
    public Level(int f)
     {
        fee=f;
     }
    
    String getLevel()
    {
        String str="";
        if (this instanceof Gold)
        {
            str="Gold";
        }
        if (this instanceof Silver)
        {
            str="Silver";
        }
         if (this instanceof Platnuim)
        {
            str="Platnuim";
        }
      return str;
    }
abstract void changeLevel(Customer c);
            
}
