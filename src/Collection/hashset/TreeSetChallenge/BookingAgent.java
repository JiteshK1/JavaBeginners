package Collection.hashset.TreeSetChallenge;

public class BookingAgent {
    public static void main(String[] args) {

        int row = 10;
        int seats=100;
        Theatre theatre = new Theatre("Pingoli",row,seats);
        theatre.printSeatMap();
        bookSeat(theatre,'A',5);
        bookSeat(theatre,'L',5);

    }

    private static void bookSeat(Theatre theatre, char row, int seatNo) {
        String seat = theatre.reserveSeat(row,seatNo);
        if (seat!=null){
            System.out.println("Congratulations! Your reserved seat is " + seat);
            theatre.printSeatMap();
        }else {
            System.out.println("Seat's already reserved.");
        }
    }
}
