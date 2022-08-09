package dev.cornejo.entities;

import javax.management.openmbean.InvalidOpenTypeException;

public class Expense {
    private static int expenseId;
    private double cost;
    private Status status;
    private String issuingEmployee;
    private String description;
    private Type type;

    public Expense(int expenseId, double cost, String status, String employee, String description, String type) {
    }

    public static int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost() {
        this.cost = cost;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIssuingEmployee() {
        return issuingEmployee;
    }

    public void setIssuingEmployee() {
        this.issuingEmployee= issuingEmployee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

