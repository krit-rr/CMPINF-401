package lab04_krr92;

public class Location {

    private String street;
    private String city;
    private int zip;
    private String state;

//  You must add constructors, toString, getters, and setters , etc
    public Location(String street, String city, int zip, String state) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
    }

    public String toString() {
        return ("Street: " + street
                + "\nCity: " + city
                + "\nZip: " + zip
                + "\nState: " + state);
    }

    public String street() {
        return street;
    }

    public void street(String street) {
        this.street = street;
    }

    public String city() {
        return city;
    }

    public void city(String city) {
        this.city = city;
    }

    public int zip() {
        return zip;
    }

    public void zip(int zip) {
        this.zip = zip;
    }

    public String state() {
        return state;
    }

    public void state(String state) {
        this.state = state;
    }

}
