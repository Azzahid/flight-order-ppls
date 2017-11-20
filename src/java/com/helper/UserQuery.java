/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import com.entity.Booking;
import com.entity.Flight;
import com.entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author azzah
 */
public class UserQuery extends DbConnector{
    
    private static long TokenTime = 24*3600*1000;
    
    public UserQuery() {
        super();
    }
    
    public User login(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = '"
                +username
                +"' AND password = '" + password + "';";
        String queryUpdateToken = "UPDATE Users SET token = ?, validDate = ?"
                +" WHERE Id = ?;";
        User user = new User();
        try{
            Integer userId;
            rs = st.executeQuery(query);
            if(rs.next()){
                userId = rs.getInt("Id");
                PreparedStatement ps;
                String token = UUID.randomUUID().toString();
                Timestamp validDate = new Timestamp(System.currentTimeMillis()+UserQuery.TokenTime);
                ps = con.prepareStatement(queryUpdateToken);
                ps.setString(1, token);
                ps.setTimestamp(2, validDate);
                ps.setInt(3, userId);
                ps.execute();
                ps.close();
                user.setId(userId);
                user.setUsername(username);
                user.setName(rs.getString("Name"));
                user.setToken(token);
            }else{
                return user;
            }   
        } catch (SQLException ex) {
            System.out.println("Result: " + ex.toString());
        } 
        return user;
    }
    
    public User register(String username, String password, String name)
    {
        User user = new User();
        String token = UUID.randomUUID().toString();
        Timestamp validDate = new Timestamp(System.currentTimeMillis()+UserQuery.TokenTime);
        
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setToken(token);
        user.setValidDate(validDate);
        try {
            utx.begin();
            em.joinTransaction();
            em.persist(user);
            em.flush();
            em.refresh(user);
            utx.commit();
            return user;
        } catch (Exception Ex) {
            System.out.println(Ex.toString());
        }
        
        return null;
    }
    
    public boolean checkToken(Integer userId, String token) {
        String query = "SELECT * FROM Users WHERE userid = "+userId+";";
        try{
            rs = st.executeQuery(query);
            if(rs.next()){
                String tokenDB = rs.getString("token");
                long validDate = rs.getTimestamp("validDate").getTime();
                if (tokenDB.equals(token)) {
                    if (System.currentTimeMillis() >= validDate) {
                        return true;
                    }
                }
            }  
        } catch (SQLException ex) {
            System.out.println("Result: " + ex.toString());
        }    
        return false;
    }
    
    public User getUser(Integer userId, String token) {
        TypedQuery<User> query = em.createNamedQuery("User.findById",User.class);
        query.setParameter("id", userId);
        User results = query.getSingleResult();
        long validDate = results.getValidDate().getTime();
        String tokenDB = results.getToken();
        if (tokenDB.equals(token)) {
            if (System.currentTimeMillis() >= validDate) {
                return results;
            }
        }
        return null;
    }
    
    public List<Booking> getBookingWithID(Integer userId, String token) {
        if (checkToken(userId, token)) {
            TypedQuery<Booking> query = em.createNamedQuery("Booking.findByUserId",Booking.class);
            query.setParameter("Id", userId);
            List<Booking> results = query.getResultList();
            
            return results;
        }
        
        return null;
    }
}
