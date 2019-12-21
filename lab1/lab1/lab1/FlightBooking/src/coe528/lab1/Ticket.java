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
public class Ticket {
    Passenger passenger;
    Flight flight;
    double price;
    static int number=1;
    Ticket(Passenger p, Flight flight, double price)
        {
            passenger=p;
            this.flight=flight;
            this.price=price;
            number++;
        }
    Passenger getpassenger()
        {
            return passenger;
        }
    Flight getFlight()
        {
            return flight;
        }
    double getPrice()
        {
            return price;
        }
    int getNumber()
        {
            return number;
        }
    void setpassenger(Passenger pass)
        {
            passenger=pass;
        }
    void setFlight(Flight f)
        {
            flight=f;
        }
    void setPrice(double p)
         {
            price=p;
        }
    void setNumber(int num)
        {
            number=num;
        }
    @Override
    public String toString()
    {
        return (passenger+", "+flight+", "+"ticket price: "+ price);
    
    }
            
}
