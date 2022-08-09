package dev.cornejo.services.expenses;
import dev.cornejo.daos.expensedaos.ExpenseDAO;
import dev.cornejo.entities.Expense;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseDAO expenseDAO;

    public ExpenseServiceImpl(ExpenseDAO expenseDAO){
        this.expenseDAO = expenseDAO;
    }

    @Override
    public Expense registerExpense(Expense expense) {

        if(expense.getExpenseId() == 0){
            throw new RuntimeException("Id cannot be empty");
        }

        if(expense.getExpenseId() == 0){
            throw new RuntimeException("ID length cannot be empty");
        }

        Expense savedExpense = this.expenseDAO.createExpense(expense);

        return savedExpense;
    }

    @Override
    public Expense retrieveExpenseById
            (int expenseId) {
        return this.expenseDAO.getExpenseById(expenseId);
    }

    @Override
    public boolean deleteExpense(int expenseId) {
        return this.expenseDAO.deleteExpenseById(expenseId);
    }

    @Override
    public Expense modifyExpense(Expense expense) {
        if(Expense.getExpenseId() == 0){
            throw new RuntimeException("ID cannot be Empty");
        }

        if(Expense.getExpenseId() == 0){
            throw new RuntimeException("ID cannot be empty");
        }
        return this.expenseDAO.updateExpense(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseDAO.getAllExpenses();
    }

    @Override
    public List<Expense> getExpenseById(int expenseId) {
        List<Expense> allExpenses = this.getAllExpenses();

        List<Expense> sortedExpenseList =
                allExpenses.stream().filter(expense -> expense.getExpenseId() ==(expenseId)).collect(Collectors.toList());

        return sortedExpenseList;
    }
}
