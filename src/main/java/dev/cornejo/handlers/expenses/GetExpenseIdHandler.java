package dev.cornejo.handlers.expenses;

import com.google.gson.Gson;
import dev.cornejo.app.App;
import dev.cornejo.entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetExpenseIdHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int expenseId = Integer.parseInt(ctx.pathParam("expenseId"));
        Expense expense = App.expenseServices.retrieveExpenseById(expenseId);
        Gson gson = new Gson();
        String json = gson.toJson(expense);
        ctx.result(json);
    }
}
