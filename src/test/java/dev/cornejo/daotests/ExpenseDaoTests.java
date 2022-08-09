package dev.cornejo.daotests;
import dev.cornejo.daos.expensedaos.ExpenseDAO;
import dev.cornejo.daos.expensedaos.ExpenseDaoPostgres;
import dev.cornejo.entities.Expense;
import dev.cornejo.utils.ConnectionUtil;
import org.junit.jupiter.api.*;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExpenseDaoTests {

    static ExpenseDAO expenseDAO = new ExpenseDaoPostgres();

    static void setup() {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "create expense table(\n" +
                    "\t id serial primary key,\n" +
                    "\t name varchar(100) not null,\n" +
                    "\t type varchar(100) not null,\n" +
                    "\t cost int default 0\n" +
                    ");";

            Statement statement = conn.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        @Test
        @Order(1)
        void create_expense_test(){
         Expense expense = new Expense(1,50.00,"pending","Mike","New supplies","Work");
         Expense savedExpense = expenseDAO.createExpense(expense);
            Assertions.assertNotEquals(0,savedExpense.getExpenseId());
            System.out.println(expense);
        }

        @Test
        @Order(2)
        void get_expense_by_id_test(){
            Expense expense = expenseDAO.getExpenseById(1);
            Assertions.assertEquals(1,expense.getExpenseId());
        }

        @Test
        @Order(3)
        void update_expense_test(){
            Expense expensev2 = new Expense(1,50.00,"pending","Mike","new supplies","work expense");
            expenseDAO.updateExpense(expensev2);
            Expense expense = expenseDAO.getExpenseById(1);
            Assertions.assertEquals(0,1, expense.getExpenseId());
        }

        @Test
        @Order(4)
        void delete_expense_by_id(){
            boolean result = expenseDAO.deleteExpenseById(1);
            Assertions.assertTrue(result);
        }

        @Test
        @Order(5)
        void get_all_expenses_test(){
            Expense expense1 = new Expense(1,100,"Approved","Nicholas","Work Supplies", "Work");
            Expense expense2 = new Expense(2,300,"Pending","Billy","Groceries","Food");
            Expense expense3 = new Expense(3,25.00,"Pending","Rob","Bus Fare","Travel");
            Expense expense4 = new Expense(4,274.75,"Denied","Mary","Christmas toys","Personal");

            expenseDAO.createExpense(expense1);
            expenseDAO.createExpense(expense2);
            expenseDAO.createExpense(expense3);
            expenseDAO.createExpense(expense4);

            List<Expense> ExpenseList = expenseDAO.getAllExpenses();
            Assertions.assertEquals(4,ExpenseList.size());
        }

    }

