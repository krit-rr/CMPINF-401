package lab05_krr;

import java.util.ArrayList;

public class Lab05_KRR {

    public static void main(String[] args) {
        new Lab05_KRR();
    }

    public Lab05_KRR() {
        //Mechanical Tools
        toolsMechanic drill = new toolsMechanic(30.99, "Ryobi", true, "rubber", 5032532, "USDE");
        toolsMechanic tractor = new toolsMechanic(10000.00, "John Deere", false, "plastic", 3242012, "USDA");
        //House Tools
        toolsHouse ductTape = new toolsHouse(5.00, "Duck Brand", true, "tape", true);
        toolsHouse flexGlue = new toolsHouse(10.00, "Flex", true, "glue", true);
        //Adult Clothing
        clothingAdult gucciBelt = new clothingAdult(100.00, "Gucci", false, "leather", true);
        clothingAdult buttonDown = new clothingAdult(15.00, "Kohls", true, "cotton", false);
        //Kid Clothing
        clothingKid velcroShoes = new clothingKid(20.00, "Sketchers", false, "Polyester", true, "USHHS");
        clothingKid bracelet = new clothingKid(5.00, "Lego", true, "Plastic", true, "USHHS");
        //Watch
        watch diamond = new watch(375.99, "Coach", false, true, "Debeer", "mechanical", "gold");
        watch Apple = new watch(450.99, "Apple", true, true, "Apple", "electrical", "rubber");
        //Ring
        ring platinum = new ring(1500.00, "Omega", true, true, "Debeer", 7, true);
        ring gold = new ring(1200.00, "Kendra Scott", true, true, "Debeer", 6, false);

        ArrayList<Merchandise> Searz = new ArrayList<Merchandise>();
        Searz.add(drill);
        Searz.add(tractor);
        Searz.add(ductTape);
        Searz.add(flexGlue);
        Searz.add(gucciBelt);
        Searz.add(buttonDown);
        Searz.add(velcroShoes);
        Searz.add(bracelet);
        Searz.add(diamond);
        Searz.add(Apple);
        Searz.add(platinum);
        Searz.add(gold);
        System.out.println(Searz);
    }
}
