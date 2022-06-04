package lab05_krr;

public class ring extends jewelry{
    public int fingerSize;
    public boolean diamond;
    
    public ring (double price, String brand, boolean inStock, boolean authen, String issuer, int fingerSize, boolean diamond) {
        super(price, brand, inStock, authen, issuer);
        this.fingerSize = fingerSize;
        this.diamond = diamond;
    }
    
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("\n Ring Info: ");
        info.append("Price: " + price).append(", Brand: ").append(brand).append(", In Stock: ").append(inStock).append(", Certificate of Authenticity: ").append(authen).append(", Issuer of Certificate: ").append(issuer).append(", Finger Size: ").append(fingerSize).append(", Has Diamond: ").append(diamond);
        return info.toString();
    }
}
