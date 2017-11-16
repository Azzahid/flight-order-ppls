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
    public Booking CreateBooking(@WebParam(name = "id") int id, @WebParam(name = "status") String status, @WebParam(name = "passengerName") String passengerName, @WebParam(name = "flightId") Flight flightId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelBooking")
    @Oneway
    public void cancelBooking(@WebParam(name = "id") int id) {
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ModifyBooking")
    @Oneway
    public void ModifyBooking(@WebParam(name = "id") int id, @WebParam(name = "status") String status, @WebParam(name = "passengerName") String passengerName, @WebParam(name = "flightId") Flight flightId) {
    }
}
