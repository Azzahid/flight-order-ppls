/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import com.entity.Flight;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.joda.time.DateTimeComparator;

/**
 *
 * @author azzah
 */
public class FlightQuery extends DbConnector{
    
    public FlightQuery() {
        super();
    }
    
    public List<Flight> getFlightsFromAirport(int destAirportId, int depAirportId) {
        TypedQuery<Flight> query = em.createNamedQuery("Flight.findByAirport",Flight.class);
        query.setParameter("destAirportId", destAirportId);
        query.setParameter("depAirportId", depAirportId);
        List<Flight> results = query.getResultList();
        return results;
    }
    
    public List<Flight> getFlightsFromLocation(int destLocationId, int depLocationId) {
        TypedQuery<Flight> query = em.createNamedQuery("Flight.findByLocation",Flight.class);
        query.setParameter("destLocationId", destLocationId);
        query.setParameter("depLocationId", depLocationId);
        List<Flight> results = query.getResultList();
        return results;
    }
    
    public List<Flight> getAllFlights() {
        TypedQuery<Flight> query = em.createNamedQuery("Flight.findAll",Flight.class);
        List<Flight> results = query.getResultList();
        return results;
    }
    
    
    public List<Flight> getFlightsFromDate(List<Flight> flights, Date BoardingDate) {
        int size = flights.size();
        for (int i = 0; i < size; i++) {
            Flight flight = flights.get(i);
            int compare = DateTimeComparator.getDateOnlyInstance().compare(BoardingDate, flight.getBoardingTime());
            if (compare != 0) {
                flights.remove(i);
                i--;
                size = flights.size();
            }
        }
        
        return flights;
    }
    
    public List<Flight> getFlightsFromAirportAndDate(int destAirportId, int depAirportId, Date BoardingDate) {
        List<Flight> flights = getFlightsFromAirport(destAirportId, depAirportId);
        return this.getFlightsFromDate(flights, BoardingDate);
    }
    
    public List<Flight> getFlightFromLocationAndDate(int destLocationId, int depLocationId, Date BoardingDate) {
        List<Flight> flights = this.getFlightsFromLocation(destLocationId, depLocationId);
        return this.getFlightsFromDate(flights, BoardingDate);
    }
    
}
