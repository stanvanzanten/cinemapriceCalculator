package domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        String pattern = "E, dd MMM yyyy HH:mm:ss z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("nl", "NL"));
        Movie mOne = new Movie ("Rise of plantet of the Apes");
        Movie mTwo = new Movie ("Kim Yung Un, Good or Bad?");

        LocalDate date = LocalDate.of(2020, Month.FEBRUARY, 15);
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        MovieScreening screeningOne = new MovieScreening(mOne, dateTime, 10);
        MovieScreening screeningTwo = new MovieScreening(mTwo, dateTime, 10);

        MovieTicket ticketOne = new MovieTicket(screeningOne, false, 4, 5);
        MovieTicket ticketTwo = new MovieTicket(screeningOne, true, 4, 4);
        MovieTicket ticketThree = new MovieTicket(screeningOne, true, 4, 3);
        MovieTicket ticketFour = new MovieTicket(screeningOne, false, 4, 2);
        MovieTicket ticketFive = new MovieTicket(screeningOne, false, 4, 1);
        MovieTicket ticketSix = new MovieTicket(screeningOne, false, 4, 6);

        Order orderOne = new Order(1, true);
        orderOne.addSeatReservation(ticketOne);
        orderOne.addSeatReservation(ticketTwo);
        orderOne.addSeatReservation(ticketThree);
        orderOne.addSeatReservation(ticketFour);
        orderOne.addSeatReservation(ticketFive);
        orderOne.addSeatReservation((ticketSix));

//        try {
//            String title = "You have reserved tickets for the movie: "+ screeningOne + " on " + screeningOne.getDateAndTime().getDayOfWeek();
//            String totalprice = "\nThe total price of your order: " + orderOne.calculatePrice() + " eurootjes";
//            File newTextFile = new File("/Users/stan/Documents/Avans/Avans jaar 3/SOA 3/ticketorder1.txt");
//
//            FileWriter fw = new FileWriter(newTextFile);
//            fw.write(title);
//            fw.write(totalprice);
//            fw.close();
//
//        } catch (IOException iox) {
//            //do stuff with exception, i don't
//            iox.printStackTrace();
//        }
//
//        orderOne.export(TicketExportFormat.PLAINTEXT);

        System.out.println("The total price of your order: " + orderOne.calculatePrice() + " eurootjes");

        System.out.println("You have reserved tickets for the movie: "+ screeningOne);
        System.out.println("This movie is screened on: " + screeningOne.getDateAndTime().getDayOfWeek());
    }
}