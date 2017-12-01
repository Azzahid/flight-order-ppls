package com.entity;

import com.entity.Airport;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-01T15:22:10")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> province;
    public static volatile SingularAttribute<Location, String> town;
    public static volatile SingularAttribute<Location, Integer> id;
    public static volatile CollectionAttribute<Location, Airport> airportCollection;

}