package dev.cornejo.daos.expensedaos;

import dev.cornejo.daos.expensedaos.ExpenseDAO;
import dev.cornejo.entities.Expense;
import dev.cornejo.utils.ConnectionUtil;

import java.sql.*;
import java.util.List;

public class ExpenseDaoPostgres implements ExpenseDAO {
    @Override
    public Expense createExpense(Expense expense) {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "insert into expense values (default, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,  expense.getExpenseId());
            preparedStatement.setDouble(2, expense.getCost());
            preparedStatement.setString(3, expense.getIssuingEmployee());
            preparedStatement.setString(4, expense.getDescription());
            preparedStatement.setString(5, expense.getType().name());
            preparedStatement.setString(6, expense.getStatus());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();// returns the id that was created
            rs.next();// you have to move the curosr to the first valid record

            int generatedKey = rs.getInt("expenseId");
            expense.setExpenseId(generatedKey);
            return expense;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Expense getExpenseById(int expenseId) {
        return null;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return null;
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return null;
    }

    @Override
    public boolean deleteExpenseById(int expenseId) {
        return false;
    }
}
