package lab04_krr92;

public class House {

    // class fields
    private int numberOfBeds;
    private int numberOfBaths;
    private double footage;
    private String type;

// You must add constructors, toString, getters, and setters , etc.
    public House(int numberOfBeds, int numberOfBaths, double footage, String type) {
        this.numberOfBeds = numberOfBeds;
        this.numberOfBaths = numberOfBaths;
        this.footage = footage;
        this.type = type;
    }

    public String toString() {
        return ("\nNumber of Beds: " + numberOfBeds
                + "\nNumber of Baths: " + numberOfBaths
                + "\nFootage: " + footage
                + "\nType: " + type);
    }

    public int numberOfBeds() {
        return numberOfBeds;
    }

    public void numberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int numberOfBaths() {
        return numberOfBaths;
    }

    public void numberOfBaths(int numberOfBaths) {
        this.numberOfBaths = numberOfBaths;
    }

    public double footage() {
        return footage;
    }

    public void footage(double footage) {
        this.footage = footage;
    }

    public String type() {
        return type;
    }

    public void type(String type) {
        this.type = type;
    }

}
