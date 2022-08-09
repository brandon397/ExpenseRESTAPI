package dev.cornejo.daos.employeedaos;

import dev.cornejo.daos.expensedaos.EmployeeDAO;
import dev.cornejo.entities.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDaoLocal implements EmployeeDAO {

    private Map<Integer, Employee> employeeTable = new HashMap<>();
    private int idMaker = 1;

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(idMaker++);
        idMaker++;
        employeeTable.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeTable.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        return false;
    }
}
