package S1_N3;

public class Seat {
    private int row;
    private int seat;
    private String name;


    public Seat(String name, int row, int seat){
        this.name = name;
        this.row = row;
        this.seat = seat;
    }


    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public boolean equals(int qRow, int qSeat){
        return (this.row == qRow && this.seat ==qSeat);
    }
    public boolean equals(Seat otherSeat){
        return (this.row == otherSeat.getRow() && this.seat == otherSeat.getSeat());
    }
    public String toString(){
        return String.format("Row: %d, Seat: %d, Person: %s",
                this.row, this.seat, this.name);
    }

}
