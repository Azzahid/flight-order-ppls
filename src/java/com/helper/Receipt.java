/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import com.entity.Booking;
import com.entity.Bookingpassenger;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author azzah
 */
public class Receipt extends DbConnector{
    Booking bookingInfo;
    
    public Receipt(int bookingId) {
        TypedQuery<Booking> query = em.createNamedQuery("Booking.findById", Booking.class).setParameter("id", bookingId);
        bookingInfo = query.getSingleResult();
    }
    
    public String generateReceipt() {
        String results;
        results = "Ordered by : " + bookingInfo.getUserId().getName() + "\n";
        results += "Order time : " + bookingInfo.getBookingTime().toString()+"\n";
        results += "Flight detail :\n";
        results += "\t Departure : "+bookingInfo.getFlightId().getDepartureId().getAirportID().getName()
                +" ("+bookingInfo.getFlightId().getDepartureId().getAirportID().getLocationId().getTown()
                +")\n";
        results += "\t Destination : "+bookingInfo.getFlightId().getDestinationId().getAirportID().getName()
                +" ("+bookingInfo.getFlightId().getDestinationId().getAirportID().getLocationId().getTown()
                +")\n";
        results += "\t Boarding Time : "+bookingInfo.getFlightId().getBoardingTime().toString()+"\n";
        results += "Passenger :\n";
        for (Bookingpassenger passenger : bookingInfo.getBookingpassengerCollection()) {
            results += "\t Name : " + passenger.getPassengerId().getPassengerName()+"\n";
        }
        results += "Total Price : Rp."+bookingInfo.getTotalPrice()+"\n";
        return results;
    }
    
}
