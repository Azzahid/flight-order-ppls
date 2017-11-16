/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Booking;
import com.entity.Flight;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Date;
import com.helper.BookingQuery;

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
     */
    @WebMethod(operationName = "CreateBooking")
    public Booking CreateBooking(@WebParam(name = "id") int id, @WebParam(name = "status") String status, @WebParam(name = "totalPrice") double totalPrice, @WebParam(name = "paymentMethod") String paymentMethod, @WebParam(name = "bookingTime") Date bookingTime, @WebParam(name = "flightId") Flight flightId, @WebParam(name = "userId") int userId) {
        //TODO write your implementation code here:
        Booking booking = new Booking(id, status, totalPrice, paymentMethod, bookingTime);
        booking.setFlightId(flightId);
        
        //booking.setUserId(userId); how to find user by id
        
        BookingQuery bookingQuery = new BookingQuery();
        bookingQuery.insertBooking(booking);
        
        return booking;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelBooking")
    @Oneway
    public void cancelBooking(@WebParam(name = "id") int id) {
        // ????
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ModifyBooking")
    @Oneway
    public void ModifyBooking(@WebParam(name = "id") int id, @WebParam(name = "status") String status, @WebParam(name = "totalPrice") double totalPrice, @WebParam(name = "paymentMethod") String paymentMethod, @WebParam(name = "bookingTime") Date bookingTime, @WebParam(name = "flightId") Flight flightId, @WebParam(name = "userId") int userId) {


    }
}
