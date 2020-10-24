/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

import java.io.Serializable;

/**
 *
 * @author Corey
 */

public class Keywords implements Serializable {
    private int id;
    private int userId;
    private int numOfBathrooms;
    private int numOfBedrooms;
    private int numOfGarages;

    public Keywords(int id, int userId, int numOfBathrooms, int numOfBedrooms, int numOfGarages) {
        this.id = id;
        this.userId = userId;
        this.numOfBathrooms = numOfBathrooms;
        this.numOfBedrooms = numOfBedrooms;
        this.numOfGarages = numOfGarages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumOfBathrooms() {
        return numOfBathrooms;
    }

    public void setNumOfBathrooms(int numOfBathrooms) {
        this.numOfBathrooms = numOfBathrooms;
    }

    public int getNumOfBedrooms() {
        return numOfBedrooms;
    }

    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
    }

    public int getNumOfGarages() {
        return numOfGarages;
    }

    public void setNumOfGarages(int numOfGarages) {
        this.numOfGarages = numOfGarages;
    }


}