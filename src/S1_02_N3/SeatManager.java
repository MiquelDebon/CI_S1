package S1_02_N3;

import java.util.ArrayList;

public class SeatManager {
    private ArrayList<Seat> seatList;


    public SeatManager(){
        this.seatList = new ArrayList<Seat>();
    }


    public ArrayList<Seat> getSeatList() {
        return this.seatList;
    }
    public void setSeatList(ArrayList<Seat> seatList){
        this.seatList = seatList;
    }
    public void addSeat(Seat newSeat)  throws ExceptionSeatInUse {
        boolean inUse = false;

        if(this.seatList.size() == 0 || (searchSeat(newSeat.getRow(), newSeat.getSeat()) != -1)){
            this.seatList.add(newSeat);
        }else{
            throw new ExceptionSeatInUse("This seat is already in use");
        }
    }
    public void deleteSeat(int qRow, int qSeat) throws ExceptionEmptySeat{
        int index = searchSeat(qRow, qSeat);
        if(index != -1){
            this.seatList.remove(index);
        }else{
            throw new ExceptionEmptySeat("The Seat is available");
        }
    }

    public int searchSeat(int qRow, int qSeat){
        int index = -1;
        for(int i=0; i<this.seatList.size(); i++){
            if(this.seatList.get(i).equals(qRow, qSeat)){
                index = i;
                i = this.seatList.size();
            }
        }
        return index;
    }

    public ArrayList<Seat> searchIndexSeatByName(String name) throws NullPointerException{
        ArrayList<Seat> seatByPerson = new ArrayList<Seat>();
        for(int i=0; i<this.seatList.size(); i++){
            if(this.seatList.get(i).getName().equalsIgnoreCase(name)){
                seatByPerson.add(this.seatList.get(i));
            }
        }
        return seatByPerson;
    }

}
