package dev.cornejo.services.employee;

import dev.cornejo.daos.expensedaos.EmployeeDAO;
import dev.cornejo.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeServices {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }
    @Override
    public Employee registerEmployee(Employee employee) {

        if(employee.getName().length() == 0){
            throw new RuntimeException("Name cannot be empty");
        }

        if(employee.getId() == 0){
            throw new RuntimeException("ID length cannot be empty");
        }

        Employee savedEmployee = this.employeeDAO.createEmployee(employee);

        return savedEmployee;
    }

    @Override
    public Employee retrieveEmployeeById(int id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean isSuccessful = this.employeeDAO.deleteEmployeeById(id);
        return isSuccessful;
    }

    @Override
    public Employee modifyEmployee(Employee employee) {

        if(employee.getName().length() == 0){
            throw new RuntimeException("Name cannot be Empty");
        }

        if(employee.getId() == 0){
            throw new RuntimeException("ID cannot be empty");
        }
        return this.employeeDAO.updateEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        List<Employee> allEmployees = this.getAllEmployees();

        List<Employee> sortedEmployeeList =
                allEmployees.stream().filter(employee -> employee.getName().equals(name)).collect(Collectors.toList());

        return sortedEmployeeList;
    }
}
