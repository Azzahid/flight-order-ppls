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
import com.entity.BookingInfo;
import com.entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public List<BookingInfo> getMyBooking(int userId, String token) {
        if (checkToken(userId, token)) {
            List<BookingInfo> tickets = new Vector<>();
            String queryTickets = "SELECT * FROM bookings WHERE userid = "+userId+";";

            try {
                rs = st.executeQuery(queryTickets);
                while(rs.next()){
                    BookingInfo booking = new BookingInfo();
                    FlightInfo 
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }
}
