package dev.cornejo.daos.employeedaos;

import dev.cornejo.daos.expensedaos.EmployeeDAO;
import dev.cornejo.entities.Employee;
import dev.cornejo.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoPostgres implements EmployeeDAO {
    @Override
    public Employee createEmployee(Employee employee) {
        try (Connection conn = ConnectionUtil.createConnection()) {
            //insert into employee values (default, 'The Stranger', 'Albert Camus', 0);
            String sql = "insert into employee values (default, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getId());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();// returns the id that was created
            rs.next();// you have to move the curosr to the first valid record

            int generatedKey = rs.getInt("id");
            employee.setId(generatedKey);
            return employee;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        try (Connection connection = ConnectionUtil.createConnection()) {
            String sql = "Select * from employee where id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));

            return employee;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try (Connection connection = ConnectionUtil.createConnection()) {
            String sql = "select * from employee";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            List<Employee> employeeList = new ArrayList();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employeeList.add(employee);
            }
            return employeeList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "update set employee name = ?, where is = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getId());

            preparedStatement.executeUpdate();
            return employee;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean deleteEmployeeById(int id) {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "delete from employee where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

