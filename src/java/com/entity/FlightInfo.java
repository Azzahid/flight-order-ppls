/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author azzah
 */
public class FlightInfo extends Flight{
    public Location locationInfo;
    
    public FlightInfo() {
        super();
        locationInfo = new Location();
    }
}
