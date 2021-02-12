package domain.State;

import domain.Order;

public class ReservedState implements State{

    Order order;

    public ReservedState(Order order) {this.order = order;}

    @Override
    public void create() {
        System.out.println("Error: You already created and submitted your order, please proceed.");
    }

    @Override
    public void submit() {
        System.out.println("Error: You already submitted an order, please proceed.");
    }

    @Override
    public void reserve() {
        System.out.println("Error: You already are in the reserved state.");
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
