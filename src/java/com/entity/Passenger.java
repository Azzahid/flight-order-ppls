/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author azzah
 */
@Entity
@Table(name = "passenger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p")
    , @NamedQuery(name = "Passenger.findById", query = "SELECT p FROM Passenger p WHERE p.id = :id")
    , @NamedQuery(name = "Passenger.findByPassengerName", query = "SELECT p FROM Passenger p WHERE p.passengerName = :passengerName")
    , @NamedQuery(name = "Passenger.findByIdUsed", query = "SELECT p FROM Passenger p WHERE p.idUsed = :idUsed")
    , @NamedQuery(name = "Passenger.findByIdNumber", query = "SELECT p FROM Passenger p WHERE p.idNumber = :idNumber")})
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "PassengerName")
    private String passengerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "IdUsed")
    private String idUsed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "IdNumber")
    private String idNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passengerId")
    private Collection<Bookingpassenger> bookingpassengerCollection;
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User userId;

    public Passenger() {
    }

    public Passenger(Integer id) {
        this.id = id;
    }

    public Passenger(Integer id, String passengerName, String idUsed, String idNumber) {
        this.id = id;
        this.passengerName = passengerName;
        this.idUsed = idUsed;
        this.idNumber = idNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getIdUsed() {
        return idUsed;
    }

    public void setIdUsed(String idUsed) {
        this.idUsed = idUsed;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @XmlTransient
    public Collection<Bookingpassenger> getBookingpassengerCollection() {
        return bookingpassengerCollection;
    }

    public void setBookingpassengerCollection(Collection<Bookingpassenger> bookingpassengerCollection) {
        this.bookingpassengerCollection = bookingpassengerCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Passenger[ id=" + id + " ]";
    }
    
}
