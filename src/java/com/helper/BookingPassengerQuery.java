/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import com.entity.Booking;
import com.entity.Bookingpassenger;
import com.entity.Passenger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.SystemException;

/**
 *
 * @author azzah
 */
public class BookingPassengerQuery extends DbConnector{
    public BookingPassengerQuery() {
        super();
    }
    
    public boolean createBookingPassenger(List<Integer> passengerId, int bookingId) {
        try {
            utx.begin();
            em.joinTransaction();
            for(Integer i : passengerId) {
                Bookingpassenger bp = new Bookingpassenger();
                bp.setBookingId(new Booking(bookingId));
                bp.setPassengerId(new Passenger(i));
                em.persist(bp);
                em.flush();
                em.refresh(bp);
            }
            utx.commit();
            return true;
        } catch (Exception ex) {
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
