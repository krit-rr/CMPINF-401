package lab04_krr92;

//    Note , when writing your equals() method, a property is consider equal to another one if the number of beds, baths, and type are the same.
//    You must add constructors, toString, getters, and setters, etc.
public class Property {

    private House house;           //  agregation
    private Location location;     //  agregation
    private String saleDate;
    private double price;

    public Property(String rawInfo) {

        String[] propertyInfo = rawInfo.trim().split(",");
        String street = propertyInfo[0].trim();
        String city = propertyInfo[1].trim();
        int zip = Integer.parseInt(propertyInfo[2].trim());
        String state = propertyInfo[3].trim();

        int numberOfBeds = Integer.parseInt(propertyInfo[4].trim());
        int numberOfBaths = Integer.parseInt(propertyInfo[5].trim());
        double footage = Double.parseDouble(propertyInfo[6].trim());
        String type = propertyInfo[7].trim();

        saleDate = propertyInfo[8].trim();
        price = Double.parseDouble(propertyInfo[9].trim());
        location = new Location(street, city, zip, state);
        house = new House(numberOfBeds, numberOfBaths, footage, type);

    }

    public Property(Property currentProperty) {
        house = currentProperty.house();
        location = currentProperty.location();
        saleDate = currentProperty.saleDate();
        price = currentProperty.getPrice();
    }

    public String toString() {
        return ("House: " + house
                + "\nLocation: " + location
                + "\nSale Date: " + saleDate
                + "\nPrice: " + price
                + "\n================================================");
    }

    public boolean equals(Property currentProperty) {
        if (house.numberOfBeds() == currentProperty.house.numberOfBeds()) {
            if (house.numberOfBaths() == currentProperty.house.numberOfBaths()) {
                if (house.type().equals(currentProperty.house.type())) {
                    return true;
                }
            }
        }
        return false;

    }

    public House house() {
        return house;
    }

    public void house(House houses) {
        house = houses;
    }

    public Location location() {
        return location;
    }

    public void saleDate(Location locations) {
        location = locations;
    }

    public String saleDate() {
        return saleDate;
    }

    public void saleDate(String saleDates) {
        saleDate = saleDates;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double prices) {
        price = prices;
    }

}
