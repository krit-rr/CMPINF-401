package lab05_krr;

public class clothing extends Merchandise {
    public String fabric;
    
    public clothing (double price, String brand, boolean inStock, String fabric) {
        super(price, brand, inStock);
        this.fabric = fabric;
    }
}
