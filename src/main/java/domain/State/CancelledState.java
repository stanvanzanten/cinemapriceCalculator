package domain.State;

import domain.Order;

public class CancelledState implements State {

    Order order;

    public CancelledState(Order order) {this.order = order;}

    @Override
    public void create() {
        System.out.print("Error: You canceled your order, please start over again if you wish to do so.");
    }

    @Override
    public void submit() {
        System.out.print("Error: You canceled your order, please start over again if you wish to do so.");

    }

    @Override
    public void reserve() {
        System.out.print("Error: You canceled your order, please start over again if you wish to do so.");
    }

    @Override
    public void pay() {
        System.out.print("Error: You canceled your order, please start over again if you wish to do so.");
    }

    @Override
    public void cancel() {
        System.out.println("Error: You already are in the cancelled state.");
    }
}
