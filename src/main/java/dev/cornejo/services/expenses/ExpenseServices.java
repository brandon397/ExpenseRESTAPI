package dev.cornejo.services.expenses;
import dev.cornejo.entities.Expense;
import java.util.List;

public interface ExpenseServices {

    Expense registerExpense (Expense expense);

    Expense retrieveExpenseById (int expenseId);

    boolean deleteExpense (int expenseId);

    Expense modifyExpense (Expense expense);

    List<Expense> getAllExpenses();

    List<Expense> getExpenseById(int expenseId);

}

