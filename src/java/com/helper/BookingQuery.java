/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import java.util.Date;
import com.entity.Booking;
import com.entity.Bookingpassenger;
import com.entity.Passenger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

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
    
    public Booking createBooking(Booking booking) {
        try {
            utx.begin();
            em.joinTransaction();
            em.persist(booking);
            em.flush();
            em.refresh(booking);
            utx.commit();
            return booking;
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(FlightQuery.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println(ex.toString());
        }
        
        return booking;
    }
    
    public boolean updateBookingJPA(Booking booking) {
        Booking bookingDB = em.find(Booking.class, booking.getId());
        try {
            utx.begin();
            em.joinTransaction();
            if (booking.getStatus() != null && !booking.getStatus().isEmpty()) {
                bookingDB.setStatus(booking.getStatus());
            }
            if (booking.getPaymentMethod()!= null && !booking.getPaymentMethod().isEmpty()) {
                bookingDB.setPaymentMethod(booking.getPaymentMethod());
            }
            utx.commit();
            return true;
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception ex1) {
                Logger.getLogger(PassengerQuery.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println(ex.toString());
        }
        
        return true;
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
    
    public Booking getBooking(int id) {
        TypedQuery<Booking> query = em.createNamedQuery("Booking.findById",Booking.class);
        query.setParameter("id", id);
        Booking results = query.getSingleResult();
        return results;
    }
    
    public double countTotalBookingPrice(Booking booking) {
        double price = booking.getBookingpassengerCollection().size()*booking.getFlightId().getPrice();
        return price;
    }
    
    public double countTotalBookingPriceWithFlightId(Booking booking) {
        FlightQuery flight = new FlightQuery();
        double flightPrice;
        flightPrice = flight.getFlight(booking.getFlightId().getId()).getPrice();
        double price = booking.getBookingpassengerCollection().size()*flightPrice;
        return price;
    }
    
    public boolean cancelBooking(int id) {
        Booking booking = em.find(Booking.class, id);
        try {
            utx.begin();
            em.joinTransaction();
            em.remove(booking);
            utx.commit();
            return true;
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(FlightQuery.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println(ex.toString());
        }
         
        return false;
    }
}
