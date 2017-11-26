/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.helper.UserQuery;
import java.util.List;
import java.util.Vector;
import com.entity.Booking;
import com.entity.User;

/**
 *
 * @author azzah
 */
@WebService(serviceName = "userService")
public class UserService {
    
    /**
     * @param userId Id user,
     * @param token Token from user,
     * @return User
     */
    @WebMethod(operationName = "checkToken")
    public boolean checkToken(@WebParam(name = "userId")int userId, @WebParam(name = "token")String token) {
        UserQuery query = new UserQuery();
        return true;//query.checkToken(userId, token);
    }
    
    /**
     * @param username
     * @param password
     * @return String
     */
    @WebMethod(operationName = "login")
    public User login (@WebParam(name = "username")String username, 
            @WebParam(name = "password")String password) {
        UserQuery query = new UserQuery();
        return query.login(username, password);
    }
    
    @WebMethod(operationName = "getMyBooking")
    public List<Booking> getMyBooking(@WebParam(name = "userId")int userId, 
            @WebParam(name = "token")String token) {
        UserQuery query = new UserQuery();
        List<Booking> tickets = query.getBookingWithID(userId, token);
        return tickets;
    }
    
        /**
     * @param username
     * @param password
     * @return String
     */
    @WebMethod(operationName = "register")
    public User register (
            @WebParam(name = "username")String username, 
            @WebParam(name = "password")String password,
            @WebParam(name = "name" )String name) {
        UserQuery query = new UserQuery();
        return query.register(username, password, name);
    }
}
