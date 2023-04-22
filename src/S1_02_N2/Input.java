package S1_02_N2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);
    static Boolean rightInput = false;

    static public void printShouldBe(String type){
        System.out.print("⚠️ Please write a valid input [" + type + "] -> ✏️: ");
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


    //Integer
    public static int readInteger(String message){
        rightInput = false;
        int integer = -1;

        System.out.print(message);
        do{
            try{
                integer = sc.nextInt();
                rightInput = true;
            }catch (InputMismatchException e){
                printShouldBe("Integer");
            }
            sc.nextLine();

        }while(!rightInput);
        return integer;
    }


    //Float
    public static float readFloat(String message){
        rightInput = false;
        float floatNumber = -1.0f;

        System.out.print(message);
        do{
            try{
                floatNumber = sc.nextFloat();
                rightInput = true;
            }catch (InputMismatchException e){
                printShouldBe("Float");
            }
            sc.nextLine();

        }while(!rightInput);
        return floatNumber;
    }


    //Double
    public static double readDouble(String message){
        rightInput = false;
        double doubleNumber = -1.0f;

        System.out.print(message);
        do{
            try{
                doubleNumber = sc.nextDouble();
                rightInput = true;
            }catch (InputMismatchException e){
                printShouldBe("Double");
            }
            sc.nextLine();

        }while(!rightInput);
        return doubleNumber;
    }


    //Character
    public static char readChar(String message){
        rightInput = false;
        String stringChar = "";
        char charValue = ' ';

        System.out.print(message);
        do{
            try{
                stringChar = sc.nextLine();
                if(stringChar.length() == 1){
                    charValue = stringChar.charAt(0);
                    rightInput = true;
                }else{
                    printShouldBe("Character");
                }
            }catch (Exception e){
                printShouldBe("Character");
            }
        }while(!rightInput);
        return charValue;
    }


    //String
    public static String readString(String message){
        rightInput = false;
        String stringValue = "";

        System.out.print(message);
        do{
            try{
                stringValue = sc.nextLine();
                rightInput = true;
            }catch (Exception e){
                printShouldBe("String");
            }
        }while(!rightInput);
        return stringValue;
    }


    //Boolean
    public static boolean readYesNo(String message){
        rightInput = false;
        String stringBoolean = "";
        boolean booleanValue = false;

        System.out.print(message);
        do{
            try{
                stringBoolean = sc.next();
                if(stringBoolean.equalsIgnoreCase("Y")){
                    booleanValue = true;
                    rightInput = true;
                }else if(stringBoolean.equalsIgnoreCase("N")){
                    rightInput = true;
                }else{
                    printShouldBe("Y/N");
                }
            }catch (Exception e){
                printShouldBe("Y/N");
            }
        }while(!rightInput);
        return booleanValue;
    }


    //Advanced Integer
    public static int inputReturnIntWhileBetweenRange(int valorInferiorInclos , int valorSuperiorInclos, String message) {
        int numero = 0;
        rightInput = false;

        System.out.print(message);
        do {
            try {
                numero = sc.nextInt();
                rightInput = (numero >= valorInferiorInclos && numero <= valorSuperiorInclos) ? true : false;
                if(!rightInput){
                    printShouldBe("Integer");
                }
            } catch (InputMismatchException ex) {
                printShouldBe("Integer");
            }
            sc.nextLine();
        } while (!rightInput);
        return numero;
    }




}
