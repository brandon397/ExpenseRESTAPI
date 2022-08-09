package dev.cornejo.daotests;

import dev.cornejo.daos.employeedaos.EmployeeDaoPostgres;
import dev.cornejo.daos.expensedaos.EmployeeDAO;
import dev.cornejo.entities.Employee;
import dev.cornejo.utils.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EmployeeDaoTests {

    static EmployeeDAO employeeDAO = new EmployeeDaoPostgres();

    static void setup(){
        try (Connection conn = ConnectionUtil.createConnection()){
            String sql = "create expense table(\n" +
                    "\t id serial primary key,\n" +
                    "\t name varchar(100) not null,\n"+
                    ");";
            Statement statement = conn.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    void create_employee_test(){
        Employee employee = new Employee(4,"Daniel");
        Employee savedEmployee = employeeDAO.createEmployee(employee);
        Assertions.assertNotEquals(0,savedEmployee.getName());
    }

    @Test
    void update_employee_test(){
        Employee employee = new Employee(3,"Brandon");
        employeeDAO.updateEmployee(employee);
        Employee savedEmployee = employeeDAO.getEmployeeById(3);
        Assertions.assertNotEquals(0,savedEmployee.getId(),savedEmployee.getName());
    }

    @Test
    void delete_employee_test(){
        boolean result = employeeDAO.deleteEmployeeById(1);
        Assertions.assertTrue(result);
    }
    @Test
    void get_all_employee_test(){
        Employee employee1 = new Employee(1,"Nicholas");
        Employee employee2 = new Employee(2,"Billy");
        Employee employee3 = new Employee(3,"Rob");
        Employee employee4 = new Employee(4,"Mary");

        employeeDAO.createEmployee(employee1);
        employeeDAO.createEmployee(employee2);
        employeeDAO.createEmployee(employee3);
        employeeDAO.createEmployee(employee4);

        List<Employee> EmployeeList = employeeDAO.getAllEmployees();
        Assertions.assertEquals(4,EmployeeList.size());
    }
}
