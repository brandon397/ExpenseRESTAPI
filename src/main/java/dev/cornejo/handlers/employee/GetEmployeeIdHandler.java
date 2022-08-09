package dev.cornejo.handlers.employee;
import com.google.gson.Gson;
import dev.cornejo.app.App;
import dev.cornejo.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

//Get an employees ID
public class GetEmployeeIdHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Employee employee = App.employeeService.retrieveEmployeeById(id);
        Gson gson = new Gson();
        String json = gson.toJson(employee);
        ctx.result(json);
    }
}
