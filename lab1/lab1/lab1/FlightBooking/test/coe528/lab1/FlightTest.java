/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janeeta Zahid
 */
public class FlightTest {
    
    public FlightTest() {
    }
    //Testing the Constructor with proper inputs
    @org.junit.Test
    public void testConstrcutor()
    {
        System.out.println("Testing Constructor");
        Flight flightt =new Flight (2,"Japan","Canada","2:00",30,2000);
        
    }
    //testing constructor with invalid argumenta
     @org.junit.Test
    public void testInvalidConstrcutor()
    {
        System.out.println("Testing Constructor");
        Flight flightt =new Flight (2,"Canada","Canada","2:00",30,2000);
    }
  

    //Test getflightNumber()
    @org.junit.Test
    public void testgetflightNumber() {
        System.out.println(" testing getflightNumber method");
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        int expResult = 2;
        int result = f.getflightNumber();
        //if the expected result and the result are the same the methd works 
        assertEquals(expResult, result);
    }

    //test getOrgin()
    @org.junit.Test
    public void testGetorgin() {
        System.out.println("testing getorgin()");
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        String expResult = "Japan";
        String result = f.getorgin();
        assertEquals(expResult, result);
    }

    //Test getorgin
    @org.junit.Test
    public void testgetdestination() {
        System.out.println("testing getdestination()");
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        String expResult = "Canada";
        String result = f.getdestination();
        assertEquals(expResult, result);
    }

   //Test getdepartureTime()
    @org.junit.Test
    public void testgetdepartureTime() {
        System.out.println("test getdepartureTime()");
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        String expResult = "2:00";
        String result = f.getdepartureTime();
        assertEquals(expResult, result);
    }

   
     // Test getcapacity() 
    
    @org.junit.Test
    public void testgetcapacity() {
        System.out.println("test getcapacity()");
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        int expResult = 30;
        int result = f.getcapacity();
        assertEquals(expResult, result);
    }

  
      //Test  getnumberOfSeatsLeft()
     
    @org.junit.Test
    public void testgetnumberOfSeatsLeft() {
        System.out.println("testing getnumberOfSeatsLeft()");
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        int expResult = 30;
        int result = f.getnumberOfSeatsLeft();
        assertEquals(expResult, result);
    }

    
    // Test of getoriginalPrice()
     
    @org.junit.Test
    public void testgetoriginalPrice() {
        System.out.println("testing getoriginalPrice()");
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        double expResult = 2000;
        double result = f.getoriginalPrice();
        assertEquals(expResult, result,0.001);
    }

    
      //Test of setflightNumber()
     
    @org.junit.Test
    public void testsetflightNumber() {
        System.out.println("testing setflightNumber");
        int i = 20;
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        f.setflightNumber(i);
    }

    //tesing setorgin()
    @org.junit.Test
    public void testSetorgin() {
        System.out.println("testing setorgin()");
        String o = "New York";
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        f.setorgin(o);
    }

   
     // Test  setdestination()
     
    @org.junit.Test
    public void testsetdestination() {
        System.out.println("tetsing setdestination()");
        String d = "Paris";
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        f.setdestination(d);
    }

      // Test  setdepartureTime()
    @org.junit.Test
    public void testsetdepartureTime() {
        System.out.println("testing setdepartureTime()");
        String dt = "2:30";
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        f.setdepartureTime(dt);
    }

   // Test  setcapacity()
    @org.junit.Test
    public void testsetcapacity() {
        System.out.println("testing setcapacity()");
        int c = 80;
        Flight f= new Flight(2,"Japan","Canada","2:00",30,2000);
        f.setcapacity(c);
    }

    // Test  setnumberOfSeatsLeft()
    @org.junit.Test
    public void testSetnumberOfSeatsLeft() {
        System.out.println("testing setnumberOfSeatsLeft()");
        int n = 2;
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        f.setnumberOfSeatsLeft(n);
    }

    // Test  setoriginalPrice()
    @org.junit.Test
    public void testsetoriginalPrice() {
        System.out.println("testing setoriginalPrice()");
        double price = 300.0;
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        f.setoriginalPrice(price);
    }

    //Testing BookaSeat()
    @org.junit.Test
    public void testBookASeat() {
        System.out.println(" testing bookASeat()");
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        boolean expResult = true;
        boolean result = f.bookASeat();
        assertEquals(expResult, result);
    }

    //testing toString()
    @org.junit.Test
    public void testToString() {
        System.out.println("testing toString()");
        Flight f = new Flight(2,"Japan","Canada","2:00",30,2000);
        String expResult = "Flight number 2, is going from Japan to Canada, at 2:00, original price: 2000.0$";
        String result = f.toString();
        assertEquals(expResult, result);
    }
   
    
    
    
}
