package lab05_krr;

public class tools extends Merchandise {

    public String material;

    public tools(double price, String brand, boolean inStock, String material) {
        super(price, brand, inStock); 
        this.material = material;
    }
}
