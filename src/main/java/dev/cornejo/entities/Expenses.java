package dev.cornejo.entities;

public class Expenses {
    private int id;
    private double cost;
    private Status status;
    private Employee employee;
    private String description;
    private Type type;

    public Expenses(int id, double cost, Status status, Employee employee, String description, Type type) {
        this.id = id;
        this.cost = cost;
        this.status = status;
        this.employee = employee;
        this.description = description;
    }
}

