/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Passenger;
import com.helper.PassengerQuery;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author azzah
 */
@WebService(serviceName = "PassengerService")
public class PassengerService {

    /**
     * 
     * @param id
     * @return 
     */
    @WebMethod(operationName = "getPassengerById")
    public Passenger getPassengerById(@WebParam(name = "id") int id) {
        PassengerQuery query = new PassengerQuery();
        return query.getPassengerFromId(id);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "getPassengerByUserId")
    public List<Passenger> getPassengerByUserId(@WebParam(name = "id") int id) {
        PassengerQuery query = new PassengerQuery();
        return query.getPassengerFromUserId(id);
    }
    
    @WebMethod(operationName = "createPassenger")
    public boolean createPassenger(@WebParam(name = "passenger") Passenger passenger) {
        PassengerQuery query = new PassengerQuery();
        return query.createPassenger(passenger);
    }
    
    @WebMethod(operationName = "updatePassenger")
    public boolean updatePassenger(@WebParam(name = "passenger") Passenger passenger) {
        PassengerQuery query = new PassengerQuery();
        return query.updatePassenger(passenger);
    }
}
