package dev.cornejo.app;

import dev.cornejo.entities.Employee;
import dev.cornejo.handlers.employee.CreateEmployeeHandler;
import dev.cornejo.handlers.employee.GetEmployeeIdHandler;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

// You will be creating a REST API for an expense reimbursement system.
// The system will allow the company to track expenses and analyze spending.
// You will design the entities. You have two entities. Employee and Expense.
// You will demo your application 8/10.
public class App {

    public static List<Employee> employees = new ArrayList(); //Hold id's on server

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        CreateEmployeeHandler createEmployeeHandler = new CreateEmployeeHandler();
        GetEmployeeIdHandler getEmployeeIdHandler = new GetEmployeeIdHandler();

        app.get("/id", getEmployeeIdHandler);
        app.get("/name", createEmployeeHandler);

        app.start();
    }

}
