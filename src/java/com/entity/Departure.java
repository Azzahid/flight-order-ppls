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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author azzah
 */
@Entity
@Table(name = "departure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departure.findAll", query = "SELECT d FROM Departure d")
    , @NamedQuery(name = "Departure.findById", query = "SELECT d FROM Departure d WHERE d.id = :id")})
public class Departure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departureId")
    private Collection<Flight> flightCollection;
    @JoinColumn(name = "airportID", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Airport airportID;

    public Departure() {
    }

    public Departure(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flightCollection) {
        this.flightCollection = flightCollection;
    }

    public Airport getAirportID() {
        return airportID;
    }

    public void setAirportID(Airport airportID) {
        this.airportID = airportID;
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
        if (!(object instanceof Departure)) {
            return false;
        }
        Departure other = (Departure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Departure[ id=" + id + " ]";
    }
    
}
