package com.entity;

import com.entity.Departure;
import com.entity.Destination;
import com.entity.Location;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-01T15:22:10")
@StaticMetamodel(Airport.class)
public class Airport_ { 

    public static volatile CollectionAttribute<Airport, Departure> departureCollection;
    public static volatile CollectionAttribute<Airport, Destination> destinationCollection;
    public static volatile SingularAttribute<Airport, Location> locationId;
    public static volatile SingularAttribute<Airport, String> name;
    public static volatile SingularAttribute<Airport, Integer> id;

}