package com.entity;

import com.entity.Booking;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-14T23:18:54")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Date> validDate;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile CollectionAttribute<User, Booking> bookingCollection;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> token;

}