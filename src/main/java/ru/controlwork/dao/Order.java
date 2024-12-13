package ru.controlwork.dao;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Order {
    private int id;
    private String dishes;
    private int tableNumber;
    private String waiter;
    public Order(int id, String dishes, int tableNumber, String waiter) {
        this.id = id;
        this.dishes = dishes;
        this.tableNumber = tableNumber;
        this.waiter = waiter;
    }
}
