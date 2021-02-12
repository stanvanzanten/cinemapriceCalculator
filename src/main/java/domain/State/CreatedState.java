package domain.State;

import domain.Order;

public class CreatedState implements State {

    Order order;

    public CreatedState(Order order) {this.order = order;}

    @Override
    public void create() {
        System.out.println("Error: you are already in the created state");
    }

    @Override
    public void submit() {
        System.out.println("You submitted your order. You can pay later.");
        order.setState(new SubmittedState(this.order));
    }

    @Override
    public void reserve() {
        System.out.println("Error: you can not reserve seats from the created state");
    }

    @Override
    public void pay() {
        System.out.println("Error: you can not pay from the created state");
    }

    @Override
    public void cancel() {
        System.out.println("Your order is cancelled. Restart the process if you want to start again.");
        order.setState(new CancelledState(this.order));
    }
}
