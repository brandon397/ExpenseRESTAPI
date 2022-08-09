package dev.cornejo.daos.expensedaos;
import dev.cornejo.entities.Employee;
import java.util.List;

public interface EmployeeDAO {

    Employee createEmployee (Employee employee);

   Employee getEmployeeById (int id);

   List<Employee> getAllEmployees();

   //Update
    Employee updateEmployee(Employee employee);

    //Delete
    boolean deleteEmployeeById(int id);


}
