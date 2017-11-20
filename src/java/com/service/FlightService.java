/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Departure;
import com.entity.Destination;
import com.entity.Flight;
import com.helper.FlightQuery;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author azzah
 */
@WebService(serviceName = "FlightService")
public class FlightService {

    /**
     * This is a sample web service operation
     * @param destinationLocationID
     * @param departureLocationID
     * @return List of flight
     */
    @WebMethod(operationName = "getFlightsFromLocation")
    public List<Flight> getFlightsFromLocation(
            @WebParam(name = "destinationLocationID") int destinationLocationID,
            @WebParam(name = "departureLocationID") int departureLocationID) {
        FlightQuery query = new FlightQuery();
        List<Flight> flights = query.getFlightsFromLocation(destinationLocationID, departureLocationID);
        
        return flights;
    }
    
    /**
     *
     * @param destinationAirportID
     * @param departureAirportID
     * @return
     */
    @WebMethod(operationName = "getFlightsFromAirport")
    public List<Flight> getFlightsFromAirport(
            @WebParam(name = "destinationAirportID") int destinationAirportID,
            @WebParam(name = "departureAirportID") int departureAirportID) {
        FlightQuery query = new FlightQuery();
        List<Flight> flights = query.getFlightsFromAirport(destinationAirportID, departureAirportID);
                
        return flights;
    }
    
    /**
     *
     * @param destinationAirportID
     * @param departureAirportID
     * @param BoardingTime
     * @return
     */
    @WebMethod(operationName = "getFlightsFromAirportAndDate")
    public List<Flight> getFlightsFromAirportAndDate(
            @WebParam(name = "destinationAirportID") int destinationAirportID,
            @WebParam(name = "departureAirportID") int departureAirportID,
            @WebParam(name = "BoardingTime") Date BoardingTime) {
        FlightQuery query = new FlightQuery();
        List<Flight> flights = query.getFlightsFromAirportAndDate(
                destinationAirportID, 
                departureAirportID, 
                BoardingTime
        );      
        
        return flights;
    }
    
    /**
     *
     * @param BoardingTime
     * @return
     */
    @WebMethod(operationName = "getFlightsFromDate")
    public List<Flight> getFlightsFromDate(@WebParam(name = "BoardingTime") Date BoardingTime) {
        FlightQuery query = new FlightQuery();
        List<Flight> flights = query.getAllFlights();
        flights = query.getFlightsFromDate(flights, BoardingTime);
        
        return flights;
    }
    
    /**
     *
     * @param flight
     * @return
     */
    @WebMethod(operationName = "createFlight")
    public boolean createFlight(@WebParam(name = "Flight") Flight flight) {
        FlightQuery query = new FlightQuery();
        return query.createFlight(flight);
    }
    
    /**
     *
     * @param destinationAirportId
     * @param departureAirportId
     * @param Company
     * @param Quota
     * @param Price
     * @param Quality
     * @param BoardingTime
     * @return
     */
    @WebMethod(operationName = "createFlightFromData")
    public boolean createFlightFromData(
            @WebParam(name = "destinationAirportId") int destinationAirportId,
            @WebParam(name = "departureAirportId") int departureAirportId,
            @WebParam(name = "Company") String Company,
            @WebParam(name = "Quota") int Quota,
            @WebParam(name = "Price") double Price,
            @WebParam(name = "Quality") String Quality,
            @WebParam(name = "BoardingTime") Date BoardingTime) {
        Flight flight = new Flight();
        flight.setBoardingTime(BoardingTime);
        flight.setCompany(Company);
        flight.setPrice(Price);
        flight.setQuality(Quality);
        flight.setQuota(Quota);
        Destination dest = new Destination();
        dest.setId(destinationAirportId);
        Departure dep = new Departure();
        dep.setId(departureAirportId);
        flight.setDestinationId(dest);
        flight.setDepartureId(dep);
        
        return createFlight(flight);
    }
    
    @WebMethod(operationName = "updateFlightData")
    public boolean updateFlightData(
            @WebParam(name = "flightId") int flightId,
            @WebParam(name = "destinationAirportId") int destinationAirportId,
            @WebParam(name = "departureAirportId") int departureAirportId,
            @WebParam(name = "Company") String Company,
            @WebParam(name = "Quota") int Quota,
            @WebParam(name = "Price") double Price,
            @WebParam(name = "Quality") String Quality,
            @WebParam(name = "BoardingTime")Date BoardingTime) {
        System.out.println("fish");
        Flight flight = new Flight();
        flight.setId(flightId);
        flight.setBoardingTime(BoardingTime);
        flight.setCompany(Company);
        flight.setPrice(Price);
        flight.setQuality(Quality);
        flight.setQuota(Quota);
        Destination dest = new Destination();
        dest.setId(destinationAirportId);
        Departure dep = new Departure();
        dep.setId(departureAirportId);
        flight.setDestinationId(dest);
        flight.setDepartureId(dep);
        FlightQuery query = new FlightQuery();
        
        return query.updateFlight(flight);
    }
}
