/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Booking;
import com.entity.Flight;
import com.entity.User;
import com.helper.BookingPassengerQuery;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Date;
import com.helper.BookingQuery;
import com.helper.FlightQuery;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author absol
 */
@WebService(serviceName = "BookingService")
public class BookingService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @param id
     * @param passengerId
     * @param paymentMethod
     * @param userId
     * @param flightId
     * @return 
     */
    @WebMethod(operationName = "CreateBooking")
    public Booking CreateBooking(
            @WebParam(name = "paymentMethod") String paymentMethod, 
            @WebParam(name = "flightId") int flightId, 
            @WebParam(name = "userId") int userId, 
            @WebParam(name = "passengerId") String passengerId) {
        //TODO write your implementation code here:
        BookingQuery bookingQuery = new BookingQuery();
        FlightQuery flightQuery = new FlightQuery();
        BookingPassengerQuery bpQuery = new BookingPassengerQuery();
        String status = "Pending";
        Flight flight = flightQuery.getFlight(flightId);
        List<Integer> pId = new Vector<Integer>();
        int i = 0;
        char a = passengerId.charAt(i);
        while(i < passengerId.length() && a != ']') {
            if(a == '[' || a == ',') {
                String id = "";
                i++;
                a = passengerId.charAt(i);
                while(a != ',' && a != ']') {
                    id += a;
                    System.out.println(a+"\n");
                    i++;
                    a = passengerId.charAt(i);
                }
                if (!id.isEmpty())
                    System.out.println("halo");
                    pId.add(Integer.parseInt(id));
            }
        }
        System.out.println(pId.toString());
        double totalPrice = pId.size()*flight.getPrice();
 
        Booking booking = new Booking(null, status, totalPrice, paymentMethod, new Date(System.currentTimeMillis()));
        booking.setFlightId(flight);
        booking.setUserId(new User(userId));
        bookingQuery.createBooking(booking);
        bpQuery.createBookingPassenger(pId, booking.getId());
        
        
        return booking;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelBooking")
    @Oneway
    public void cancelBooking(@WebParam(name = "id") int id) {
        BookingQuery bookingQuery = new BookingQuery();
        bookingQuery.cancelBooking(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ModifyBooking")
    @Oneway
    public void ModifyBooking(@WebParam(name = "id") int id, @WebParam(name = "status") String status, @WebParam(name = "totalPrice") double totalPrice, @WebParam(name = "paymentMethod") String paymentMethod, @WebParam(name = "bookingTime") Date bookingTime, @WebParam(name = "flightId") Flight flightId, @WebParam(name = "userId") int userId) {
        Booking booking = new Booking(id, status, totalPrice, paymentMethod, bookingTime);
        booking.setFlightId(flightId);
        
        //booking.setUserId(userId); how to find user by id
        
        BookingQuery bookingQuery = new BookingQuery();
        bookingQuery.updateBooking(booking);
    }
    
     /**
     * 
     * @param id
     * @return 
     */
    @WebMethod(operationName = "getBookingById")
    public Booking getBookingById(@WebParam(name = "id") int id) {
        BookingQuery query = new BookingQuery();
        return query.getBooking(id);
    }
}
