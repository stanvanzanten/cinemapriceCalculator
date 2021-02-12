package domain.State;

import domain.Order;

public class PayedState implements State{

    Order order;

    public PayedState(Order order) {this.order = order;}

    @Override
    public void create() {
        System.out.println("Error: You already payed for your order, no turning back now ;).");
    }

    @Override
    public void submit() {
        System.out.println("Error: You already payed for your order, no turning back now ;).");
    }

    @Override
    public void reserve() {
        System.out.println("Error: You already payed for your order, no turning back now ;).");
    }

    @Override
    public void pay() {
        System.out.println("Error: You already are in the payed state.");
    }

    @Override
    public void cancel() {
        System.out.println("Error: You already payed for your order, no turning back now ;).");
    }
}
