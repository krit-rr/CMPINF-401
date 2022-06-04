package lab03_krr92;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Lab03_KRR92 {

    public static void main(String[] args) {
        new Lab03_KRR92();
    }

    public Lab03_KRR92() {
        List<House> houseListing = readDatabaseContents();
        if (houseListing != null) {
            boolean doneSearchingHouses = false;

            while (!doneSearchingHouses) {
                SearchCriteria searchParameters = getSearchParameters();

                if (searchParameters != null) {
                    List<House> listOfHousesThatMeetCriteria = performTheSearch(searchParameters, houseListing);
                    showResults(listOfHousesThatMeetCriteria);

                } else {
                    doneSearchingHouses = true;
                }
                if (searchParameters != null) {
                }
            }
        }
    }

    private List<House> readDatabaseContents() {

        // opening the file containing the data 
        String filePath = "/Users/kritikaravichander/Downloads/real_estate_listing.txt";
        File file = new File(filePath);

        // read all the lines in the file and store it in a List 
        List<House> houseListing = new ArrayList();
        try ( Scanner fileScanner = new Scanner(file)) {
            // reading all the lines from the database 
            // read and discard the first line of the database since it is only  
            // a header, not actual data 
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String houseThing = fileScanner.nextLine();
                House house = new House(houseThing);
                houseListing.add(house);
            }

        } catch (Exception e) {
            houseListing = null;
            System.out.println("Error reading the house data.");
        }
//        System.out.println(houseListing.size());
        return houseListing;
    }

    private List<House> performTheSearch(SearchCriteria searchParameters,
            List<House> houseListing) {

        // check if it is time to finish the search 
        List<House> searchResults = new ArrayList<House>();

        for (House currentHouse : houseListing) {

            // street,city,zip,state,beds,baths,sq__ft,type,sale_date,price 
            if (searchParameters.doesHouseMeetCriteria(currentHouse)) {
                searchResults.add(currentHouse);
            }
        }
        return searchResults;
    }

    private void showResults(List<House> listOfHousesThatMeetCriteria) {

        // print search results only if there is any house that matches 
        // search criteria, otherwise print a statement stating that 
        // no houses match the search criteria 
        if (!listOfHousesThatMeetCriteria.isEmpty()) {
            for (House currentHouse : listOfHousesThatMeetCriteria) {
                System.out.println("=====================================");
                System.out.println(currentHouse.displayHouseInfo());
            }

        } else {
            System.out.println("No houses match the search criteria");
        }

    }

    private String displaySearchMenu() {
        // displays JOptionPane asking the user to define search parameters 
        // example: -p 450000 550000 -b 2 3 
        String message = "Choose Search Parameter: \n\n"
                + "-p min_price max_price\n"
                + "-b min_number_beds max_number_beds\n"
                + "-1 to exit\n\n";
        // price and # of bedrooms: -p 100 200 -b 2 3   or just price:  -p 100 200 
        // -1 to exit 
        String userSelection = JOptionPane.showInputDialog(message).trim();
        return userSelection;

    }

    private SearchCriteria getSearchParameters() {

        String userSelection = displaySearchMenu();
        String EXIT_REQUESTED = "-1";

        // check if it is time to finish the search 
        if (userSelection.equalsIgnoreCase(EXIT_REQUESTED)) {
            return null;
        } else {  // otherwise continue searching as requested 
            // from "-p 100 200 -b 2 3" to "-p", "100", "200", "-b", "2", and "3" 
            SearchCriteria searchParameters = new SearchCriteria(userSelection);
            return searchParameters;
        }
    }
}
