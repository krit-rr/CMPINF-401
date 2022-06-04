package lab03_krr92;

public class SearchCriteria {

    public double minPrice;
    public double maxPrice;
    public double minBeds;
    public double maxBeds;

    public SearchCriteria(String rawUserInputRequest) {
        minPrice = -1;
        maxPrice = -1;
        minBeds = -1;
        maxBeds = -1;

        String[] userInput = rawUserInputRequest.split(" ");

//          -p 300000 310000 –b 2 3
        if (userInput.length == 3) {
            if (userInput[0].equals("-p")) {
                minPrice = Double.parseDouble(userInput[1]);
                maxPrice = Double.parseDouble(userInput[2]);
            } else if (userInput[0].equals("-b")) {
                minBeds = Double.parseDouble(userInput[1]);
                maxBeds = Double.parseDouble(userInput[2]);
            }
        } else {
            if (userInput[0].equals("-p")) {
                minPrice = Double.parseDouble(userInput[1]);
                maxPrice = Double.parseDouble(userInput[2]);
                minBeds = Double.parseDouble(userInput[4]);
                maxBeds = Double.parseDouble(userInput[5]);
            } else if (userInput[0].equals("-b")) {
                minBeds = Double.parseDouble(userInput[1]);
                maxBeds = Double.parseDouble(userInput[2]);
                minPrice = Double.parseDouble(userInput[4]);
                maxPrice = Double.parseDouble(userInput[5]);
            }
        }
    }

    public boolean doesHouseMeetCriteria(House house) {

        if (minPrice <= 0) {
            if (house.beds >= minBeds && house.beds <= maxBeds) {
                return true;
            } else {
                return false;
            }
        } else if (minBeds <= 0) {
            if (house.price >= minPrice && house.price <= maxPrice) {
                return true;
            } else {
                return false;
            }
        }
            if (house.beds >= minBeds && house.beds <= maxBeds && house.price >= minPrice && house.price <= maxPrice) {
                return true;
            }
            return false;
        }
}
