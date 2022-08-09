package dev.cornejo.handlers.expenses;
import com.google.gson.Gson;
import dev.cornejo.entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateExpenseIdHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(json, Expense.class);

    }
}
