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

import java.util.ArrayList;
public class Manager {
  static ArrayList<Flight> FlightData= new ArrayList<>();
  static ArrayList<Ticket> Tickets= new ArrayList<>();
    
    public void createFlights()
    {
          Flight Berlin = new Flight(2030,"Toronto","Berlin","2:00",200,1500);
          FlightData.add(Berlin);  
          Flight NY = new Flight(2031,"Toronto","New York","3:00",200,300);
          FlightData.add(NY); 
          Flight Paris = new Flight(2035,"Toronto","Paris","15:00",2000,1700);
          FlightData.add(Paris);
          Flight London = new Flight(2031,"Toronto","London","20:00",1500,1600);
          FlightData.add(London);
    }
    
    public void displayAvalibleFlights(String orgin, String destination)
    {
        for(int i=0;i<FlightData.size();i++)
        {
           if((FlightData.get(i).orgin).equals(orgin)&&(FlightData.get(i).destination).equals(destination))
           {
                System.out.println("Flight Number "+FlightData.get(i).flightNumber+" is avalible from "+orgin+" to "+destination);
                return;
           }
        } 
        System.out.println("Sorry no flights are found between "+orgin+" and "+destination);
    }
    public Flight getFlight(int flightNumber)
       {
           Flight f=null; 
        for(int k=0;k<FlightData.size();k++)
            {
                if((FlightData.get(k).flightNumber)==flightNumber)
                {
                  f =FlightData.get(k);
                 
                } 
                else
                    if(k==FlightData.size()-1)
                {
                    System.out.println("Sorry this flight does not exsist");
                    return null;
                    
                }
              
            }
        return f;
       }
   
           
    public void bookSeat(int flightNumber, Passenger p)
        {
            double priceissued;
            for(int j=0;j<FlightData.size();j++)
            {
                if((FlightData.get(j).flightNumber)==flightNumber&&(FlightData.get(j).numberOfSeatsLeft>0))
                {
                    FlightData.get(j).capacity--;
                    FlightData.get(j).bookASeat();
                        if(p instanceof Member)
                            {
                                priceissued= p.applyDiscount(FlightData.get(j).originalPrice);
                                Ticket t = new Ticket(p,FlightData.get(j),priceissued);
                                Tickets.add(t);
                            }
                        if(p instanceof NonMember)
                            {
                                priceissued=p.applyDiscount(FlightData.get(j).originalPrice);
                                Ticket t = new Ticket(p,FlightData.get(j),priceissued);
                                Tickets.add(t);
                            }   
                        
                    
                }
            }
        }
    
    public static void main (String[] args)
        {
         
         Manager M1= new Manager();
         //create new flights that will be stored in arrray lisr
         M1.createFlights();
         //Test an anvalible Flight
         M1.displayAvalibleFlights("Toronto", "London");
         //Test a nonexsistent Flight
          M1.displayAvalibleFlights("Toronto", "Brazil");
          //test getFlight 
          //will compile sucessfully and return the flight object
          M1.getFlight(2031);
          //when sending a flight that does not exsist it will give an error message and return null
          M1.getFlight(2039);
          // Creating a new passenger who is also a member
          Passenger Todd= new Member ("Todd",23,6);
          M1.bookSeat(2035, Todd);
          //The Price for Todds original Ticket=1700
          //the new price with the discount can be acessed from the Tickets Array Lisr (in this case its in index 0)
          System.out.println("The original Ticket price was "+FlightData.get(2).originalPrice+"$"+ " but since Todd has been a member for longer than 5 years he gets a 50% discount resulting in a price of "+ Tickets.get(0).price+ "$");
          //the number of seats for the flight that has just been booked has been reduced by 1
          System.out.println("There are "+FlightData.get(2).numberOfSeatsLeft+" seats left in the Paris Flight");
          //creating a new passenger who is not a member
          Passenger Viola = new NonMember("viola",22);
          M1.bookSeat(2030, Viola);
          //since this passenger is not a member or over the age of 65 there is no discount applied to thier ticket price
          //the price of the ticket can be acessed using the Tickets arraylist, this ticket was stored into index 1
          System.out.println("The original Ticket price was "+FlightData.get(0).originalPrice+"$"+ " and there is no discount applied so it is still "+ Tickets.get(1).price+ "$");
          //when the Ticket was issued it also decremented the number of seats for that given flight
          System.out.println("There are "+FlightData.get(0).numberOfSeatsLeft+" seats left in the Berlin Flight");
          
        }
    
       
    }

