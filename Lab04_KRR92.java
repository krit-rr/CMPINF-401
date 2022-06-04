package lab04_krr92;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab04_KRR92 {

    public static void main(String[] args) throws FileNotFoundException {
        new Lab04_KRR92();
    }

    public Lab04_KRR92() throws FileNotFoundException {
        // TODO code application logic here
        String database = "/Users/kritikaravichander/Downloads/real_estate_listing.txt";
        Scanner fileScannerReference = getFileScannerReference(database);
        List<Property> propertyListing = getAllHouseListingsFromFile(fileScannerReference);
        // Class Property

        double[] priceRange = getPriceRange();
        printListOfHouseThatMatchPriceCriteria(priceRange, propertyListing);
        printListOfPropertiesThatAreSimilarToFirstProperty(propertyListing);
    }

    private Scanner getFileScannerReference(String database) throws FileNotFoundException {

        // we could surround it by try and catch ...
        File file = new File(database);
        return new Scanner(file);
    }

    private List<Property> getAllHouseListingsFromFile(Scanner fileScannerReference) {

        List<Property> propertyListings = new ArrayList();
        fileScannerReference.nextLine();  // read and disregards the first line in the file, since it is only descriptors...

        while (fileScannerReference.hasNext()) {
            Property currentProperty = new Property(fileScannerReference.nextLine());
            //  One of the Property constructors    
            propertyListings.add(currentProperty);
        }
        return propertyListings;
    }

    private double[] getPriceRange() {

        String priceRange = JOptionPane.showInputDialog("Type price range separated by comma (e.g., 100000.00, 200000.00");
        String[] prices = priceRange.split(",");
        double minPrice = Double.parseDouble(prices[0].trim());
        double maxPrice = Double.parseDouble(prices[1].trim());
        return new double[]{minPrice, maxPrice};
    }

    private void printListOfHouseThatMatchPriceCriteria(double[] priceRange, List<Property> houseListing) {

        for (Property currentProperty : houseListing) {
            if (currentProperty.getPrice() >= priceRange[0] && currentProperty.getPrice() <= priceRange[1]) {
                printHouseInfo(new Property(currentProperty));
                // Another of the Property constructors (the copy constructor)
            }
        }
    }

    private void printHouseInfo(Property property) {
        System.out.println(property);
        // the Property’s toString() method
    }

    private void printListOfPropertiesThatAreSimilarToFirstProperty(List<Property> propertyListings) {

        // getting the first property
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        Property property = propertyListings.get(0);
        for (Property currentProperty : propertyListings) {
            if (currentProperty.equals(property)) {
                //the Property’s equals() method
                System.out.println(currentProperty);
                System.out.println("++++++++++++++++++++++++++++++++++++++++");
            }
        }
    }
}
