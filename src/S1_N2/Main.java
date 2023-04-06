package S1_N2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Author: Miquel Debon Villagrasa

        System.out.println(Input.readByte("✏️Write a Byte: "));

        System.out.println(Input.readInteger("✏️Write a Integer: "));

        System.out.println(Input.readFloat("✏️Write a Float: "));

        System.out.println(Input.readDouble("✏️Write a Double: "));

        System.out.println(Input.readChar("✏️Write a Character: "));

        System.out.println(Input.readString("✏️Write a String: "));

        System.out.println(Input.readYesNo("✏️Write a Y/N: "));

        System.out.println(Input.inputReturnIntWhileBetweenRange(2,4,"✏️Write a integer between 2-4: "));

    }
}