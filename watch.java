package lab05_krr;

public class watch extends jewelry {
    public String type;
    public String bandmaterial;
    
    public watch (double price, String brand, boolean inStock, boolean authen, String issuer, String type, String bandmaterial) {
        super(price, brand, inStock, authen, issuer);
        this.type = type;
        this.bandmaterial = bandmaterial;
    }
    
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("\n Watch Info: ");
        info.append("Price: " + price).append(", Brand: ").append(brand).append(", In Stock: ").append(inStock).append(", Certificate of Authenticity: ").append(authen).append(", Issuer of Certificate: ").append(issuer).append(", Watch Type: ").append(type).append(", Band Material: ").append(bandmaterial);
        return info.toString();
    }
}
