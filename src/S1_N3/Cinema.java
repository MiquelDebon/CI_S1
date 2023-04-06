package S1_N3;

import S1_N2.Input;

public class Cinema {

    private int totalRows;
    private int totalSeatXRow;
    private SeatManager seatManager;


    public Cinema(){
        this.seatManager = new SeatManager();
        this.askInitialData();
    }


    public void askInitialData(){
        System.out.println("Welcome to the Java's Cinema Paradise");
        this.totalRows = Input.readInteger("Introduce el numero de filas ✏️: ");
        this.totalSeatXRow = Input.readInteger("Introduce el numero de butacas por fila ✏️: ");
    }
    public void run(){
        this.menu();
        int request = Input.inputReturnIntWhileBetweenRange(0,5,
                "What would you like to do? ✏️: ");
    }

    public void menu(){
        System.out.println( "\n___________________________🎬 MIQUEL CINEMA 🎬________________________" +
                            "\n   1) Show all the seats in use          4) Delete the booking" +
                            "\n   2) Show the seats by one person       5) Delete all booking by person" +
                            "\n   3) Book a seat                        0) Exit the program");
    }

}
