package lab05_krr;

public class toolsHouse extends tools {
    
    public boolean waterResistant;

    public toolsHouse(double price, String brand, boolean inStock, String material, boolean waterResistant) {
        super(price, brand, inStock, material);
        this.waterResistant = waterResistant;
    }
    
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("\n House Tool Info: ");
        info.append("Price: " + price).append(", Brand: ").append(brand).append(", In Stock: ").append(inStock).append(", Material Type: ").append(material).append(", Water Resistant: ").append(waterResistant);
        return info.toString();
    }
}
