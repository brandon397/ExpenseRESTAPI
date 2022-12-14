package dev.cornejo.handlers.expenses;

import dev.cornejo.app.App;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class DeleteExpenseHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int expenseId = Integer.parseInt(ctx.pathParam("expenseId"));
        boolean result = App.expenseServices.deleteExpense(expenseId);
        if(result){
            ctx.status(120);
        }else {
            ctx.status(404);
            ctx.result("Could not find expense");
        }

    }
}
