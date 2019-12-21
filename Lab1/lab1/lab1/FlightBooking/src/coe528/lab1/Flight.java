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
public class Flight {
    int flightNumber;
    String orgin;
    String destination;
    String departureTime;
    int capacity;
    int numberOfSeatsLeft;
    double originalPrice;
    public  Flight (int flightnum,String org, String des,String dep,int cap,int p)
    {
       if(org.equalsIgnoreCase(des))
        {
           throw new IllegalArgumentException ("Destination and orgin cannot be the same");
           
        }
       else
        {
            flightNumber= flightnum;
            orgin=org;
            destination=des;
            departureTime= dep;
            capacity= cap;
            originalPrice = p;
            //starting assuming no seats have been booked yet
            numberOfSeatsLeft=capacity;
         
        }
        
    }
    int getflightNumber()
        {
            return flightNumber;
        }
    String getorgin()
        {
            return orgin;
        }
    String getdestination()
        {   
            return destination;
        }
    String getdepartureTime()
        {
            return departureTime;
        }
    int getcapacity()
        {
            return capacity;
        }
    int getnumberOfSeatsLeft()
        {
            return numberOfSeatsLeft;
        }
    double getoriginalPrice()
        {
            return originalPrice;
        }
      void setflightNumber(int f)
        {
            flightNumber=f;
        }
    void setorgin(String or)
        {
            orgin=or;
        }
    void setdestination(String d)
        {
          destination=d;
        }
    void setdepartureTime(String dt)
        {
            departureTime=dt;
        }
    void setcapacity(int c)
        {
            capacity=c;
        }
    void setnumberOfSeatsLeft(int n)
        {
            numberOfSeatsLeft=n;
        }
    void setoriginalPrice(double price)
        {
            originalPrice=price;
        }
    boolean bookASeat()
        {
            if(numberOfSeatsLeft>0)
                {
                    numberOfSeatsLeft--;
                    return true;
                }
            else
                {
                    return false;
                }
        }
    @Override 
     public String toString()
        {
            return ("Flight number "+flightNumber+", is going from "+orgin+" to "+destination+", at "+departureTime+", "+"original price: "+originalPrice+"$");
        }
    
}
