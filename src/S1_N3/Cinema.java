package S1_N3;

import S1_N2.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {
    static Scanner sc = new Scanner(System.in);
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
        boolean exit = false;
        do{
            switch (this.menu()){
                case 0:
                    exit = true;
                    break;
                case 1:
                    showAllBookedSeats();
                    break;
                case 2:
                    showSeatByPerson();
                    break;
                case 3:
                    bookSeat();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    cancelBookingByPerson();
                    break;
            }
        }while(!exit);
    }

    public int menu(){
        System.out.println( "\n___________________________🎬 MIQUEL CINEMA 🎬________________________" +
                            "\n   1) Show all the seats booked          4) Delete the booking" +
                            "\n   2) Show the seats by one person       5) Delete all booking by person" +
                            "\n   3) Book a seat                        0) Exit the program");
        return Input.inputReturnIntWhileBetweenRange(0,5,
                "What would you like to do? ✏️: ");
    }

    public void showAllBookedSeats(){
        System.out.println("☑️ Option 1 - Show all the seats booked");
        if(this.seatManager.getSeatList().size() == 0){
            System.out.println("There is any seat booked");
        }else{
            for(Seat seat : this.seatManager.getSeatList()){
                System.out.println(seat);
            }
        }
        System.out.println("✅ Option 1 - DONE");

    }

    public void showSeatByPerson(){
        String name = "";
        ArrayList<Seat> listOfSeat = null;
        System.out.println("☑️ Option 2 - Show the seats by one person");
        name = Input.readString("What is your name? ✏️: ");
        try{
            listOfSeat = this.seatManager.searchIndexSeatByName(name);
            if(listOfSeat.size() == 0 ){
                System.out.println("We don't have any reservation with this name");
            }else{
                for(Seat seat : listOfSeat){
                    System.out.println(String.format("Your Seat is at %d row, %d seat",
                            seat.getRow(), seat.getSeat()));
                }

            }
        }catch (NullPointerException npe){
            System.out.println("There is no Seat at this name");
        }

        System.out.println("✅ Option 2 - DONE");
    }

    public void bookSeat(){
        /* reservarButaca: Demana a l’usuari/ària un número de fila (crida al mètode introduirFila), un número de seient
        (crida almètode introduirSeient), el nom de la persona que fa la reserva (crida al mètode introduirPersona) i reserva la butaca. */
        boolean succeed = false;
        do{
            try {
                int row = this.addRow();
                int seat = this.addSeat();
                String name = this.addPerson();
                this.seatManager.addSeat(new Seat(name, row, seat));
                succeed = true;
            } catch (ExceptionWrongRow e) {
                System.out.println("Wrong row");
            }catch (ExceptionWrongSeat e) {
                System.out.println("Wrong Seat");
            }catch (ExceptionNamePerson e) {
                System.out.println("Wrong name");
            } catch (ExceptionSeatInUse e) {
                System.out.println("Seat in use");
            }
        }while(!succeed);
    }
    public void cancelBooking(){
        int index = -1;
        try {
            int row = this.addRow();
            int seat = this.addSeat();
            this.seatManager.deleteSeat(row, seat);
        } catch (ExceptionWrongRow e) {
            System.out.println("Wrong row");
        }catch (ExceptionWrongSeat e) {
            System.out.println("Wrong seat");
        }catch(ExceptionEmptySeat e){
            System.out.println("Empty seat");
        }
    }
    public void cancelBookingByPerson(){
        String name = Input.readString("What is your name? ✏️: ");
        try{
            this.seatManager.searchIndexSeatByName(name);
        }catch (NullPointerException npe){
            System.out.println("There is no seat book with this name");
        }
    }

    public String addPerson() throws ExceptionNamePerson{
        String name= "";
        try{
            name = Input.readString("What is your name :");
        }catch (Exception enp){
            throw new ExceptionNamePerson();
        }
        return name;
    }

    public int addRow() throws ExceptionWrongRow {
        int row = Input.readInteger(String.format("Which ROW do you want (1-%d)? ✏️: ", this.totalRows));
//        row = Input.inputReturnIntWhileBetweenRange(1, this.totalRows,
//                String.format("Which ROW do you want (1-%d)? ✏️: ", this.totalRows));
        if(row>1 && row <this.totalRows){
            return row;
        }else{
            throw new ExceptionWrongRow();
        }
    }

    public int addSeat() throws ExceptionWrongSeat{
        int seat = Input.readInteger(String.format("Which SEAT do you want (1-%d)? ✏️: ", this.totalSeatXRow));
        if(seat>1 && seat<this.totalRows){
            return seat;
        }else{
            throw new ExceptionWrongSeat();
        }
    }




}
