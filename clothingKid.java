package lab05_krr;

public class clothingKid extends clothing {
    public Boolean certsafe;
    public String gov;
    
    public clothingKid (double price, String brand, boolean inStock, String fabric, Boolean certsafe, String gov) {
        super(price, brand, inStock, fabric);
        this.certsafe = certsafe;
        this.gov = gov;
    }
    
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("\n Children Clothing Info: ");
        info.append("Price: " + price).append(", Brand: ").append(brand).append(", In Stock: ").append(inStock).append(", Fabric Type: ").append(fabric).append(", Certificate of Safety: ").append(certsafe).append(", Government Department: ").append(gov);
        return info.toString();
    }
}
