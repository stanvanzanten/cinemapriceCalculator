package domain;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Order
{
    private int orderNr;
    private boolean isStudentOrder;

    private ArrayList<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder)
    {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;

        tickets = new ArrayList<MovieTicket>();
    }

    public int getOrderNr()
    {
        return orderNr;
    }

    public double calculate() {
        double sum = 0.0;
        sum = Math.ceil((double)this.tickets.size() / 2);
        return sum;
    }

    public void addSeatReservation(MovieTicket ticket)
    {
        tickets.add(ticket);
    }

    public double calculateBasePrice() {
        double sum = 0.0;
        for (int i = 0; i < this.tickets.size(); i++) {
            sum += this.tickets.get(i).getPrice();
        }
        return sum;
    }


    public double PremiumPrice() {
        double amountOfTickets = this.tickets.size();
        double amountofTicketsToPayFor;
        double price = 0.0;

        if(this.isStudentOrder){
             amountofTicketsToPayFor = Math.ceil((double)amountOfTickets / 2);
        } else{
             amountofTicketsToPayFor = amountOfTickets;
        }
        for (int i = 0; i < amountofTicketsToPayFor; i++) {
            if (this.isStudentOrder && tickets.get(i).isPremiumTicket()) {
                price += 2;
            }
            else if(!this.isStudentOrder && tickets.get(i).isPremiumTicket()){
                price += 3;
            }
        }
//        if(this.tickets.size() >= 6 && !this.isStudentOrder) {
//            System.out.println("The price before the * 0.9:" + price);
//            price = price * 0.9 ;
//            return price;
//        }
        return price;
    }

    public double secondTicket() {

        double amountOfTickets = this.tickets.size();
        double amountofTicketsToPayFor;

        if(this.isStudentOrder){
            amountofTicketsToPayFor = Math.ceil((double)amountOfTickets / 2);
        } else{
            amountofTicketsToPayFor = amountOfTickets;
        }

        double price = PremiumPrice();
        System.out.println("the price" + price);
        for(int i = 0; i < amountofTicketsToPayFor; i++) {
            price += this.tickets.get(i).getPrice();
        }
        if(amountofTicketsToPayFor >= 6 && !this.isStudentOrder) {
            if(
                    this.tickets.get(0).getScreeningDay() == DayOfWeek.FRIDAY ||
                    this.tickets.get(0).getScreeningDay() == DayOfWeek.SATURDAY ||
                    this.tickets.get(0).getScreeningDay() == DayOfWeek.SUNDAY
            ) {
                price = price * 0.9;
                return price;
            }
        }
        if(amountofTicketsToPayFor >= 6 && this.isStudentOrder){
            price = price * 0.9;
            return price;
        }
        return price;
    }

    public double calculatePrice()
    {
        if(this.isStudentOrder) {
           return secondTicket();
        } else {
            if(

            this.tickets.get(0).getScreeningDay() != DayOfWeek.FRIDAY &&
                    this.tickets.get(0).getScreeningDay() != DayOfWeek.SATURDAY &&
                    this.tickets.get(0).getScreeningDay() != DayOfWeek.SUNDAY
            ) {

                return secondTicket();
            } else {
                double totalPrice = PremiumPrice() + calculateBasePrice();
                if(this.tickets.size() >= 6 && !this.isStudentOrder) {
                    System.out.println("totalprice before 10% discount: " + totalPrice);
                    totalPrice = totalPrice * 0.9 ;
                }
                return totalPrice;
            }
        }

    }

    public void export(TicketExportFormat exportFormat)
    {

        // Bases on the string respresentations of the tickets (toString), write
        // the ticket to a file with naming convention Order_<orderNr>.txt of
        // Order_<orderNr>.json

    }
}
