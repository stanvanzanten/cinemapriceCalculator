import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class Tests {
    //Start of student order tests

    @Test
    public void StudentOrderSecondFreeTest() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 25);
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Movie mvOne = new Movie("Star wars 9");
        MovieScreening screeningOne = new MovieScreening(mvOne, dateTime, 10.0);

        MovieTicket ticketOne = new MovieTicket(screeningOne, false, 4, 5);
        MovieTicket ticketTwo = new MovieTicket(screeningOne, false, 4, 4);

        Order orderOne = new Order(1, true);
        orderOne.addSeatReservation(ticketOne);
        orderOne.addSeatReservation(ticketTwo);
        orderOne.addSeatReservation(ticketOne);
        orderOne.addSeatReservation(ticketTwo);

        double expected = 20.0; //second ticket is free, (4-2)*10 = 20.0
        double calculated = orderOne.calculatePrice();
        assertEquals(expected, calculated, 0d);
    }

    @Test
    public void StudentOrderPremiumTest() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 25);
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Movie mvOne = new Movie("Star wars 9");
        MovieScreening screeningOne = new MovieScreening(mvOne, dateTime, 10.0);

        MovieTicket ticketOne = new MovieTicket(screeningOne, false, 4, 5);
        MovieTicket ticketTwo = new MovieTicket(screeningOne, true, 4, 4);
        MovieTicket ticketThree = new MovieTicket(screeningOne, true, 4, 6);

        Order orderOne = new Order(2, true);
        orderOne.addSeatReservation(ticketOne);
        orderOne.addSeatReservation(ticketTwo);
        orderOne.addSeatReservation(ticketThree);

        double expected = 22.0; //second ticket is free and one ticket is premium; 10 + 12 = 22.00
        double calculated = orderOne.calculatePrice();
        assertEquals(expected, calculated, 0d);
    }

    @Test
    public void StudentGroupOrder() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 25);
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Movie mvOne = new Movie("Star wars 9");
        MovieScreening screeningOne = new MovieScreening(mvOne, dateTime, 10.0);

        MovieTicket ticketOne = new MovieTicket(screeningOne, false, 4, 5);
        MovieTicket ticketTwo = new MovieTicket(screeningOne, false, 4, 4);
        MovieTicket ticketThree = new MovieTicket(screeningOne, false, 4, 6);
        MovieTicket ticketFour = new MovieTicket(screeningOne, false, 4, 7);
        MovieTicket ticketFive = new MovieTicket(screeningOne, false, 4, 8);
        MovieTicket ticketSix = new MovieTicket(screeningOne, false, 4, 9);

        Order orderOne = new Order(2, true);
        orderOne.addSeatReservation(ticketOne);
        orderOne.addSeatReservation(ticketTwo);
        orderOne.addSeatReservation(ticketThree);
        orderOne.addSeatReservation(ticketFour);
        orderOne.addSeatReservation(ticketFive);
        orderOne.addSeatReservation(ticketSix);

        double expected = 30.0; //Non are premium and 3 are for free so 30 should be the outcome
        double calculated = orderOne.calculatePrice();
        assertEquals(expected, calculated, 0d);
    }

    @Test
    public void NormalPremiumOrder() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 25);
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Movie mvOne = new Movie("Star wars 9");
        MovieScreening screeningOne = new MovieScreening(mvOne, dateTime, 10.0);

        MovieTicket ticketOne = new MovieTicket(screeningOne, false, 4, 5);
        MovieTicket ticketTwo = new MovieTicket(screeningOne, true, 4, 4);
        MovieTicket ticketThree = new MovieTicket(screeningOne, true, 4, 6);
        MovieTicket ticketFour = new MovieTicket(screeningOne, true, 4, 7);


        Order orderOne = new Order(3, false);
        orderOne.addSeatReservation(ticketOne);
        orderOne.addSeatReservation(ticketTwo);
        orderOne.addSeatReservation(ticketThree);
        orderOne.addSeatReservation(ticketFour);

        double expected = 49.0; //first ticket isn't premium, the rest are so: 10 + 13 + 13 + 13
        double calculated = orderOne.calculatePrice();
        assertEquals(expected, calculated, 0d);
    }

    @Test
    public void PremiumGroupOrder() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 25); //This is a Monday
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Movie mvOne = new Movie("Star wars 9");
        MovieScreening screeningOne = new MovieScreening(mvOne, dateTime, 10.0);

        MovieTicket ticketOne = new MovieTicket(screeningOne, false, 4, 5);
        MovieTicket ticketTwo = new MovieTicket(screeningOne, true, 4, 4);
        MovieTicket ticketThree = new MovieTicket(screeningOne, true, 4, 6);
        MovieTicket ticketFour = new MovieTicket(screeningOne, true, 4, 7);
        MovieTicket ticketFive = new MovieTicket(screeningOne, false, 4, 8);
        MovieTicket ticketSix = new MovieTicket(screeningOne, true, 4, 9);

        Order orderOne = new Order(3, false);
        orderOne.addSeatReservation(ticketOne);
        orderOne.addSeatReservation(ticketTwo);
        orderOne.addSeatReservation(ticketThree);
        orderOne.addSeatReservation(ticketFour);
        orderOne.addSeatReservation(ticketFive);
        orderOne.addSeatReservation(ticketSix);

        double expected = 64.8; // 4 premium and 2 regular, with 10% discount for groups = (13 * 4 + 10 * 2) * 0.9 = 64.8
        double calculated = orderOne.calculatePrice();
        assertEquals(expected, calculated, 0d);
    }

    @Test
    public void PremiumStudentGroupOrder() {
        LocalDate date = LocalDate.of(2021, Month.JANUARY, 25); //This is a Monday
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Movie mvOne = new Movie("Star wars 9");
        MovieScreening screeningOne = new MovieScreening(mvOne, dateTime, 10.0);

        MovieTicket ticketOne = new MovieTicket(screeningOne, false, 4, 5);
        MovieTicket ticketTwo = new MovieTicket(screeningOne, true, 4, 4);
        MovieTicket ticketThree = new MovieTicket(screeningOne, true, 4, 6);
        MovieTicket ticketFour = new MovieTicket(screeningOne, false, 4, 7);
        MovieTicket ticketFive = new MovieTicket(screeningOne, false, 4, 8);
        MovieTicket ticketSix = new MovieTicket(screeningOne, true, 4, 9);

        Order orderOne = new Order(3, true);
        orderOne.addSeatReservation(ticketOne);
        orderOne.addSeatReservation(ticketTwo);
        orderOne.addSeatReservation(ticketThree);
        orderOne.addSeatReservation(ticketFour);
        orderOne.addSeatReservation(ticketFive);
        orderOne.addSeatReservation(ticketSix);

        double expected = 34.0; //Half of the tickets are free because they're from students, 2 premium and 1 regular so 12 + 12 + 10.
        // They won't get a discount because of the group count after free tickets
        double calculated = orderOne.calculatePrice();
        assertEquals(expected, calculated, 0d);
    }
}
