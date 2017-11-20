/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import com.entity.Flight;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
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
    
    public boolean createFlight(Flight flight) {
        try {
            utx.begin();
            em.joinTransaction();
            em.persist(flight);
            em.flush();
            em.refresh(flight);
            utx.commit();
            return true;
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException ex1) {
                Logger.getLogger(FlightQuery.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (SecurityException ex1) {
                Logger.getLogger(FlightQuery.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (SystemException ex1) {
                Logger.getLogger(FlightQuery.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println(ex.toString());
        }
        
        return false;
    }
    
    public boolean addQuota(int flightId, int sum) {
        Flight flightDB = em.find(Flight.class, flightId);
        try {
            utx.begin();
            em.joinTransaction();
            flightDB.setQuota(flightDB.getQuota()+sum);
            utx.commit();
            return true;
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception ex1) {
                Logger.getLogger(FlightQuery.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println(ex.toString());
        }
        
        return false;
    }
    
    public boolean decreaseQuota(int flightId, int sum) {
        Flight flightDB = em.find(Flight.class, flightId);
        try {
            utx.begin();
            em.joinTransaction();
            if (flightDB.getQuota()-sum >= 0) {
                flightDB.setQuota(flightDB.getQuota()-sum);
            } else {
                throw new Exception("Quota Can't be decreased anymore");
            }
            utx.commit();
            return true;
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception ex1) {
                Logger.getLogger(FlightQuery.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println(ex.toString());
        }
        
        return false;
    }
    
    public boolean updateFlight(Flight flight) {
        Flight flightDB = em.find(Flight.class, flight.getId());
        try {
            utx.begin();
            em.joinTransaction();
            if (flight.getBoardingTime() != null) {
                flightDB.setBoardingTime(flight.getBoardingTime());
            }
            if (flight.getCompany() != null && !flight.getCompany().isEmpty()) {
                flightDB.setCompany(flight.getCompany());
            }
            if (flight.getPrice() > 0) {
                flightDB.setPrice(flight.getPrice());
            }
            if (flight.getQuota()>= 0) {
                flightDB.setQuota(flight.getQuota());
            }
            if (flight.getQuality() != null && !flight.getQuality().isEmpty()) {
                flightDB.setQuality(flight.getQuality());
            }
            if (flight.getDepartureId().getId() > 0) {
                flightDB.setDepartureId(flight.getDepartureId());
            }
            if (flight.getDestinationId().getId() > 0) {
                flightDB.setDestinationId(flight.getDestinationId());
            }
            utx.commit();
            return true;
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception ex1) {
                Logger.getLogger(FlightQuery.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println(ex.toString());
        }
        
        return false;
    }
    
    public Flight getFlight(int id) {
        TypedQuery<Flight> query = em.createNamedQuery("Flight.findById",Flight.class);
        query.setParameter("id", id);
        System.out.println(id);
        Flight results = query.getSingleResult();
        return results;
    }
}
