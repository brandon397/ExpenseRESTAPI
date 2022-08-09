package dev.cornejo.app;
import com.google.gson.Gson;
import dev.cornejo.daos.employeedaos.EmployeeDaoPostgres;
import dev.cornejo.daos.expensedaos.ExpenseDaoPostgres;
import dev.cornejo.entities.Employee;
import dev.cornejo.handlers.employee.CreateEmployeeHandler;
import dev.cornejo.handlers.employee.DeleteEmployeeByIdHandler;
import dev.cornejo.handlers.employee.GetEmployeeIdHandler;
import dev.cornejo.handlers.employee.UpdateEmployeeHandler;
import dev.cornejo.handlers.expenses.CreateExpenseIdHandler;
import dev.cornejo.handlers.expenses.DeleteExpenseHandler;
import dev.cornejo.handlers.expenses.GetExpenseIdHandler;
import dev.cornejo.handlers.expenses.UpdateExpenseHandler;
import dev.cornejo.services.employee.EmployeeServiceImpl;
import dev.cornejo.services.employee.EmployeeService;
import dev.cornejo.services.expenses.ExpenseServiceImpl;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

// You will be creating a REST API for an expense reimbursement system.
// The system will allow the company to track expenses and analyze spending.
// You will design the entities. You have two entities. Employee and Expense.
// You will demo your application 8/10.
public class App {

    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoPostgres()); //Hold id's on server for employees
    public static ExpenseServiceImpl expenseServices = new ExpenseServiceImpl(new ExpenseDaoPostgres());//Hold id's on server for expenses


    public static void main(String[] args) {
        Javalin app = Javalin.create();

        CreateEmployeeHandler createEmployeeHandler = new CreateEmployeeHandler();
        GetEmployeeIdHandler getEmployeeIdHandler = new GetEmployeeIdHandler();
        DeleteEmployeeByIdHandler deleteEmployeeByIdHandler = new DeleteEmployeeByIdHandler();
        UpdateEmployeeHandler updateEmployeeHandler = new UpdateEmployeeHandler();

        CreateExpenseIdHandler createExpenseIdHandler = new CreateExpenseIdHandler();
        GetExpenseIdHandler getExpenseIdHandler = new GetExpenseIdHandler();
        DeleteExpenseHandler deleteExpenseHandler = new DeleteExpenseHandler();
        UpdateExpenseHandler updateExpenseHandler = new UpdateExpenseHandler();

        app.post("/employee", createEmployeeHandler);
        app.get("/employee/{id}", getEmployeeIdHandler);
        app.delete("/employee/{id}",deleteEmployeeByIdHandler);
        app.put("/employee/{id}", updateEmployeeHandler);

        app.post("/expenseId", createExpenseIdHandler);
        app.get("/expenseId", getExpenseIdHandler);
        app.delete("/expenseId",deleteExpenseHandler);
        app.put("/expenseId", updateExpenseHandler);


        Handler getAllEmployees = ctx ->{
            int id = Integer.parseInt(ctx.pathParam("id"));
            Gson gson = new Gson();

        if(id == 0){
            List<Employee> employees =  App.employeeService.getAllEmployees();
            String json = gson.toJson(employees);
            ctx.result(json);
        }else{
            Employee employee = App.employeeService.retrieveEmployeeById(id);
            String json = gson.toJson(employee);
            ctx.result(json);
        }

        gson = new Gson();
        List<Employee> employees = App.employeeService.getAllEmployees();
        String json = gson.toJson(employees);
        ctx.result(json);
    };

        app.get("/employees", getAllEmployees);
        app.start();
    }

}
