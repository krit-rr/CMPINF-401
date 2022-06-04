package fxmlprojectpackage;

import java.util.*;
import javafx.scene.image.Image;


public class Car implements Insurance {
    protected String carType;
    protected String[] standardFeatures;
    protected String description;
    protected double basicPrice;
    protected String[] availableColors;
    
    public Car(String carType, String[] standardFeatures, String description,
            double basicPrice, String[] availableColors) {
        this.carType = carType;
        this.standardFeatures = standardFeatures;
        this.description = description;
        this.basicPrice = basicPrice;
        this.availableColors = availableColors;
    }
    
    public static Image getImage(String carType, String color) {
        return new Image("/resources/images/" + carType + "." + color + ".png");
    }
    
    @Override
    public double getInsurance(double basicPrice, int yearsOfInsurance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
