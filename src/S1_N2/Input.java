package S1_N2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);
    static Boolean rightInput = false;

    static public void printShouldBe(String type){
        System.out.print("⚠️ Please write a valid input [" + type + "] -> ✏️:   ");
    }


    //Byte
    public static byte readByte(String message){
        rightInput = false;
        byte btye = -1;

        System.out.print(message);
        do{
            try{
                btye = sc.nextByte();
                rightInput = true;
            }catch (InputMismatchException e){
                printShouldBe("Byte");
            }
            sc.nextLine();

        }while(!rightInput);
        return btye;
    }




}
