
package lab05_krr;

public class clothingAdult extends clothing{
    public boolean designer;
    
    public clothingAdult (double price, String brand, boolean inStock, String fabric, boolean designer) {
        super(price, brand, inStock, fabric);
        this.designer = designer;
    }
    
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("\n Adult Clothing Info: ");
        info.append("Price: " + price).append(", Brand: ").append(brand).append(", In Stock: ").append(inStock).append(", Fabric Type: ").append(fabric).append(", Designer: ").append(designer);
        return info.toString();
    }
}
