/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.helper.Receipt;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author azzah
 */
@WebService(serviceName = "ReceiptService")
public class ReceiptService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "createrReceipt")
    public String createReceipt(@WebParam(name = "bookingId") int bookingId) {
        Receipt receipt = new Receipt(bookingId);
        return receipt.generateReceipt();
    }
}
