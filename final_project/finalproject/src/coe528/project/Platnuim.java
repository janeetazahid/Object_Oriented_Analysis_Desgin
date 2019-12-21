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
public class Platnuim extends Level 
{
  
    String l="Platnuim";
    Platnuim ()
     {
        super(0);
     }
    @Override
    void changeLevel(Customer c)
     {
         if(c.balance<10000)
            {
                c.level=new Silver();
            }
         if (c.balance>=10000.00&&c.balance<20000.00)
              {
                 c.level=new Gold(); 
              }
         if(c.balance>=20000.00)
              {
                  c.level=new Platnuim();
              } 
        
    
     }

    
}
