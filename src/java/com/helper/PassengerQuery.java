/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import com.entity.Flight;
import com.entity.Passenger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;

/**
 *
 * @author azzah
 */
public class PassengerQuery extends DbConnector{
    
    public PassengerQuery() {
        super();
    }
    
    public List<Passenger> getPassengerFromUserId(int userid) {
        TypedQuery<Passenger> query = em.createNamedQuery("Passenger.findByUserId",Passenger.class);
        query.setParameter("id", userid);
        List<Passenger> results = query.getResultList();
        return results;
    }
    
    public Passenger getPassengerFromId(int id) {
        TypedQuery<Passenger> query = em.createNamedQuery("Passenger.findById",Passenger.class);
        query.setParameter("id", id);
        Passenger results = query.getSingleResult();
        return results;
    }
    public boolean createPassenger(Passenger passenger) {
        try {
            utx.begin();
            em.joinTransaction();
            em.persist(passenger);
            em.flush();
            em.refresh(passenger);
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

}
