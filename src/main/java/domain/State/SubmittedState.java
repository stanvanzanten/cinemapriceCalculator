package domain.State;

import domain.Order;

public class SubmittedState implements State{

    Order order;

    public SubmittedState(Order order) {this.order = order;}

    @Override
    public void create() {
        System.out.println("Error: You already created an order, please proceed.");
    }

    @Override
    public void submit() {
        System.out.println("Error: You already are in the submitted stage.");
    }

    @Override
    public void reserve() {
        System.out.println("Now reserving your seats, remember to pay within 12 hours before the show.");
        order.setState(new ReservedState(this.order));
    }

    @Override
    public void pay() {
        System.out.println("You have payed your order, have fun!");
        order.setState(new PayedState(this.order));
    }

    @Override
    public void cancel() {
        System.out.println("Your order is cancelled. Restart the process if you want to start again.");
        order.setState(new CancelledState(this.order));
    }
}
