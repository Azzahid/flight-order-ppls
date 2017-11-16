/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author azzah
 */
@Entity
@Table(name = "flight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f")
    , @NamedQuery(name = "Flight.findById", query = "SELECT f FROM Flight f WHERE f.id = :id")
    , @NamedQuery(name = "Flight.findByQuota", query = "SELECT f FROM Flight f WHERE f.quota = :quota")
    , @NamedQuery(name = "Flight.findByCompany", query = "SELECT f FROM Flight f WHERE f.company = :company")
    , @NamedQuery(name = "Flight.findByPrice", query = "SELECT f FROM Flight f WHERE f.price = :price")
    , @NamedQuery(name = "Flight.findByQuality", query = "SELECT f FROM Flight f WHERE f.quality = :quality")
    , @NamedQuery(name = "Flight.findByBoardingTime", query = "SELECT f FROM Flight f WHERE f.boardingTime = :boardingTime")
    , @NamedQuery(name = "Flight.findByAirport", query = "SELECT f FROM Flight f WHERE f.destinationId.airportID.id = :destAirportId AND f.departureId.airportID.id = :depAirportId")
    , @NamedQuery(name = "Flight.findByLocation", query = "SELECT f FROM Flight f WHERE f.destinationId.airportID.locationId.id = :destLocationId AND f.departureId.airportID.locationId.id = :depLocationId")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quota")
    private int quota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Quality")
    private String quality;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BoardingTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date boardingTime;
    @JoinColumn(name = "DepartureId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Departure departureId;
    @JoinColumn(name = "DestinationId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Destination destinationId;

    public Flight() {
    }

    public Flight(Integer id) {
        this.id = id;
    }

    public Flight(Integer id, int quota, String company, double price, String quality, Date boardingTime) {
        this.id = id;
        this.quota = quota;
        this.company = company;
        this.price = price;
        this.quality = quality;
        this.boardingTime = boardingTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Date getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }

    public Departure getDepartureId() {
        return departureId;
    }

    public void setDepartureId(Departure departureId) {
        this.departureId = departureId;
    }

    public Destination getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Destination destinationId) {
        this.destinationId = destinationId;
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
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Flight[ id=" + id + " ]";
    }
    
}
