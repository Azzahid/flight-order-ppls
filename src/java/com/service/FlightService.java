/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

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
    
    @WebMethod(operationName = "getFlightsFromAirport")
    public List<Flight> getFlightsFromAirport(
            @WebParam(name = "destinationAirportID") int destinationAirportID,
            @WebParam(name = "departureAirportID") int departureAirportID) {
        FlightQuery query = new FlightQuery();
        List<Flight> flights = query.getFlightsFromAirport(destinationAirportID, departureAirportID);
                
        return flights;
    }
    
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
    
    @WebMethod(operationName = "getFlightsFromDate")
    public List<Flight> getFlightsFromDate(@WebParam(name = "BoardingTime") Date BoardingTime) {
        FlightQuery query = new FlightQuery();
        List<Flight> flights = query.getAllFlights();
        flights = query.getFlightsFromDate(flights, BoardingTime);
        
        return flights;
    }
    
    
    @WebMethod(operationName = "createFlight")
    public boolean createFlight(@WebParam(name = "Flight") Flight flight) {
        
        
        return false;
    }
    
    @WebMethod(operationName = "createFlightFromData")
    public boolean createFlightFromData(
            @WebParam(name = "destinationAirportId") int destinationAirportId,
            @WebParam(name = "departureAirportId") int departureAirportId,
            @WebParam(name = "Company") String Company,
            @WebParam(name = "Quota") int Quota,
            @WebParam(name = "Price") double Price,
            @WebParam(name = "Quality") String Quality,
            @WebParam(name = "BoardingTime") Timestamp BoardingTime) {
        
        
        return false;
    }
}
