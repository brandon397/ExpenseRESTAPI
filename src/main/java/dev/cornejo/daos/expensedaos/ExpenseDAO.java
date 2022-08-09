package dev.cornejo.daos.expensedaos;
import dev.cornejo.entities.Expense;
import java.util.List;

public interface ExpenseDAO {

    Expense createExpense (Expense expense);

    Expense getExpenseById (int expenseId);
    List<Expense> getAllExpenses();

    Expense updateExpense(Expense expense);

    boolean deleteExpenseById(int expenseId);

}
