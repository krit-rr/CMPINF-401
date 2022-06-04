package lab01_KRR92;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab01_4476451 {

    public static void main(String[] args) {

        // Activity 1
        int age = 17;
        double preciseAge = 17.9;
        String name = "Krit";
        boolean isDumb = true;
        System.out.println(age);
        System.out.println(preciseAge);
        System.out.println(name);
        System.out.println(isDumb);

        
        // Activity 2
        int time = 3546;
        int hours = time / 3600;
        int seconds = time - (hours * 3600);
        int minutes = seconds / 60;
        int seconds2 = seconds % 60;
        System.out.println("It's been" + hours + "hours," + minutes + "minutes, and" + seconds2 + "seconds");

        
        // Activity 3
        double radius = 5;
        double volume = 4.0 / 3 * Math.PI * Math.pow(radius, 3);
        System.out.println("Volume is" + volume);

        
        // Activity 4
        int age1 = 21;
        int age2 = 17;
        if (age1 == age2) {
            System.out.println("Your age is 21");
        } else {
            System.out.println("Your age isn't 21");
        }

        
        // Activity 5
        double money = 10.0;
        double range = 0.05;
        double money2 = 2;

        if (Math.abs(money - money2) <= range) {
            System.out.println("They're equal");
        } else {
            System.out.println("They're not equal");
        }

        
        // Activity 6
        for (double angle = -180.0; angle < 181.0; angle++) {
            System.out.println(angle + " " + Math.sin(angle / 180.0 * Math.PI));
        }
        
        
        // Activity 7
        String[] studentNames = {"Sara", "Grace", "Sofia", "Livia", "Catherine"};
        for (String names : studentNames) {
            System.out.println(names);
        }

        
        // Activity 8
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number here:");
        int num = sc.nextInt();
        while (!(num >= 10 && num <= 20)) {
            System.out.println("This number is invalid. Please input another number");
            num = sc.nextInt();
        }

        
        // Activity 9
        int radiuss = Integer.parseInt(JOptionPane.showInputDialog("Input radius of the sphere here:"));
        double volumee = 4.0 / 3 * Math.PI * Math.pow(radiuss, 3);
        JOptionPane.showMessageDialog(null, "The volume is" + volumee);

        
        // Activity 10
        System.out.println("Enter the temperature here in Fahrenheit:");
        int temp = sc.nextInt();

        if (temp < 40) {
            System.out.println("It is cold out here.");
        } else if (temp > 40 && temp < 60) {
            System.out.println("It is okay out here.");
        } else {
            System.out.println("It is hot out here.");
        }
    }
}
