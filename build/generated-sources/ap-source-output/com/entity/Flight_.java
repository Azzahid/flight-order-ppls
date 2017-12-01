package com.entity;

import com.entity.Booking;
import com.entity.Departure;
import com.entity.Destination;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-01T15:22:10")
@StaticMetamodel(Flight.class)
public class Flight_ { 

    public static volatile SingularAttribute<Flight, Double> price;
    public static volatile SingularAttribute<Flight, Integer> quota;
    public static volatile SingularAttribute<Flight, String> company;
    public static volatile SingularAttribute<Flight, Integer> id;
    public static volatile SingularAttribute<Flight, Destination> destinationId;
    public static volatile SingularAttribute<Flight, Date> boardingTime;
    public static volatile CollectionAttribute<Flight, Booking> bookingCollection;
    public static volatile SingularAttribute<Flight, String> quality;
    public static volatile SingularAttribute<Flight, Departure> departureId;

}