/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;


import java.io.ByteArrayInputStream;
import java.sql.*;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author azzah
 */
public class DbConnector {
    protected Connection con;
    protected Statement st;
    protected ResultSet rs;
    
    @PersistenceContext
    protected EntityManager em;
    
    @Resource
    protected UserTransaction utx;

    
    public DbConnector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "flightAppPU" );
            em = emfactory.createEntityManager();
            utx = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/flightorder", "root", "");
            st = (Statement) con.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error "+ ex);
        } catch (NamingException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void finalize() {
        try {
            close();
        } finally {
            try {
                super.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void close(){
        try {
            rs.close();
            st.close();
            con.close();
            em.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
