package dev.cornejo.handlers.employee;

import dev.cornejo.app.App;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class DeleteEmployeeByIdHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int employeeId =Integer.parseInt(ctx.pathParam("id"));
        boolean result = App.employeeService.deleteEmployee(employeeId);
        if(result){
            ctx.status(120);
        }else{
            ctx.status(404);
            ctx.result("Could not find Employee");
        }

    }
}
