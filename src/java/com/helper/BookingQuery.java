/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import java.util.Date;
import com.entity.Booking;

/**
 *
 * @author absol
 */
public class BookingQuery extends DbConnector {
    public BookingQuery() {
        super();
    }
    
    public void insertBooking(int id, int userid, int flightid, String status, double totalPrice, String paymentMethod, Date bookingTime) {
        try {
            st.executeUpdate("INSERT INTO bookings VALUES (" + String.valueOf(id) + ", " + String.valueOf(userid) + ", " + String.valueOf(flightid) + ", " + status + ", " + String.valueOf(totalPrice) + ", " + paymentMethod + ", " + String.valueOf(bookingTime.getTime()) + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertBooking(Booking booking) {
        insertBooking(booking.getId(), booking.getUserId().getId(), booking.getFlightId().getId(), booking.getStatus(), booking.getTotalPrice(), booking.getPaymentMethod(), booking.getBookingTime());
    }
    
    public void updateBooking(int id, int userid, int flightid, String status, double totalPrice, String paymentMethod, Date bookingTime) {
        try {
            st.executeUpdate("UPDATE bookings SET UserId = " + String.valueOf(userid) + ", FlightId = " + String.valueOf(flightid) + ", Status = " + status + ", TotalPrice = " + String.valueOf(totalPrice) + ", PaymentMethod = " + paymentMethod + ", BookingTime" + String.valueOf(bookingTime.getTime()) + " WHERE Id = " + String.valueOf(id) + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateBooking(Booking booking) {
        updateBooking(booking.getId(), booking.getUserId().getId(), booking.getFlightId().getId(), booking.getStatus(), booking.getTotalPrice(), booking.getPaymentMethod(), booking.getBookingTime());
    }
}
