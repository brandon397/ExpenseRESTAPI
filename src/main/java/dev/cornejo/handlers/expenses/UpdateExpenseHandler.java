package dev.cornejo.handlers.expenses;

import com.google.gson.Gson;
import dev.cornejo.app.App;
import dev.cornejo.entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateExpenseHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String expenseJson = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(expenseJson, Expense.class);
        Expense updatedExpense = App.expenseServices.modifyExpense(expense);
        String json = gson.toJson(updatedExpense);
        ctx.result(json);
    }
}
