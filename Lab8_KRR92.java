package lab8_krr92;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab8_KRR92 {

    public static void main(String[] args) {
        new Lab8_KRR92();
    }

    public Lab8_KRR92() {

        try {
            divisionMethod();

        } catch (DivisionByZeroException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            inputBinaryFiles();
            outputBinaryFiles();
            readCityPopulation();
        } catch (IOException ex) {
            System.out.println();
        }
    }

    public static void divisionMethod() throws DivisionByZeroException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number here:");
        double num = sc.nextInt();
        System.out.println("Please input another number here:");
        double num2 = sc.nextInt();
        double result = num / num2;
        System.out.println(result);

        System.out.println("Please input yet another number here that happens to be zero:");
        double num3 = sc.nextInt();
        var anotherResult = num / num3;

        if (anotherResult == Double.POSITIVE_INFINITY) {
            throw new DivisionByZeroException();
        }
    }

    public static void inputBinaryFiles() throws IOException {
        FileOutputStream fstream = new FileOutputStream("binary_contents.dat");
        DataOutputStream output = new DataOutputStream(fstream);

        byte daysOfTheWeek = 7;
        short numberOfDaysInARegularYear = 365;
        char nameMiddleInitial = 'B';
        float baseLength = 5.23f;
        double veryPreciseData = 3.141592612343;
        boolean isRaining = true;
        long cityPopulation = 3000000;
        String streetAddress = "123 Banana Street";

        output.writeByte(daysOfTheWeek);
        output.writeShort(numberOfDaysInARegularYear);
        output.writeChar(nameMiddleInitial);
        output.writeFloat(baseLength);
        output.writeDouble(veryPreciseData);
        output.writeBoolean(isRaining);
        output.writeLong(cityPopulation);
        output.writeUTF(streetAddress);
        output.close();
    }

    public static void outputBinaryFiles() throws IOException {
        FileInputStream fistream = new FileInputStream("binary_contents.dat");
        DataInputStream input = new DataInputStream(fistream);
        System.out.println(input.readByte());
        System.out.println(input.readShort());
        System.out.println(input.readChar());
        System.out.println(input.readFloat());
        System.out.println(input.readDouble());
        System.out.println(input.readBoolean());
        System.out.println(input.readLong());
        System.out.println(input.readUTF());
        input.close();
    }

    public static void readCityPopulation() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("binary_contents.dat", "r");
        raf.seek(18);
        System.out.println(raf.readLong());
    }
}
