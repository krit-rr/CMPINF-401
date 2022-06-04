package lab05_krr;

public class jewelry extends Merchandise{
    public boolean authen;
    public String issuer;
    
    public jewelry (double price, String brand, boolean inStock, boolean authen, String issuer) {
        super(price, brand, inStock);
        this.authen = authen;
        this.issuer = issuer;
    }
    
}
