package com.entity;

import com.entity.Flight;
import com.entity.Location;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-14T22:09:01")
@StaticMetamodel(Airport.class)
public class Airport_ { 

    public static volatile CollectionAttribute<Airport, Flight> flightCollection1;
    public static volatile SingularAttribute<Airport, Location> locationId;
    public static volatile SingularAttribute<Airport, String> name;
    public static volatile SingularAttribute<Airport, Integer> id;
    public static volatile CollectionAttribute<Airport, Flight> flightCollection;

}