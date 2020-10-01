/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Corey
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private int id;
    private String suburb, address, state, desc, userEmail;
    private int postcode, numOfBathrooms, numOfBedrooms, numOfGarages;
    /**private Status status;

    public enum Status{
        PENDING,
        APPROVED,
        REJECTED
    } 
    **/
}
