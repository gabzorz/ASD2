package uts.asd.model;

import java.io.Serializable;

public class Calculator implements Serializable {
    
    private int priceCat;
    private int variablePrice;
    private double variableIncrease;
    private int duitableValue;

    public Calculator(int priceCat, int variablePrice, double variableIncrease, int duitableValue) {
        this.priceCat = priceCat;
        this.variablePrice = variablePrice;
        this.variableIncrease = variableIncrease;
        this.duitableValue = duitableValue;
    }

    public int getPriceCat() {
        return priceCat;
    }

    public void setPriceCat(int priceCat) {
        this.priceCat = priceCat;
    }

    public int getVariablePrice() {
        return variablePrice;
    }

    public void setVariablePrice(int variablePrice) {
        this.variablePrice = variablePrice;
    }

    public double getVariableIncrease() {
        return variableIncrease;
    }

    public void setVariableIncrease(double variableIncrease) {
        this.variableIncrease = variableIncrease;
    }

    public int getDuitableValue() {
        return duitableValue;
    }

    public void setDuitableValue(int duitableValue) {
        this.duitableValue = duitableValue;
    }
    
    
}
