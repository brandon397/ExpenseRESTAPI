package dev.cornejo.handlers.employee;

import com.google.gson.Gson;
import dev.cornejo.app.App;
import dev.cornejo.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateEmployeeHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String employeeJSON = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeJSON,Employee.class);
        Employee updatedEmployee = App.employeeService.modifyEmployee(employee);
        String json = gson.toJson(updatedEmployee);
        ctx.result(json);
    }
}
