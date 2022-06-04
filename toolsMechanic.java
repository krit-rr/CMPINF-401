package lab05_krr;

public class toolsMechanic extends tools {

    public int certNumber;
    public String govtDept;

    public toolsMechanic(double price, String brand, boolean inStock, String material, int certNumber, String govtDept) {
        super(price, brand, inStock, material);
        this.certNumber = certNumber;
        this.govtDept = govtDept;
    }
    
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("\n Mechanical Tool Info: ");
        info.append("Price: " + price).append(", Brand: ").append(brand).append(", In Stock: ").append(inStock).append(", Material Type: ").append(material).append(", Certificate Number: ").append(certNumber).append(", Government Department: ").append(govtDept);
        return info.toString();
    }
    
}
