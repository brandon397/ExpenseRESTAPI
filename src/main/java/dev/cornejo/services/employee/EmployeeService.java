package dev.cornejo.services.employee;
import dev.cornejo.entities.Employee;
import java.util.List;

public interface EmployeeService {

    Employee registerEmployee (Employee employee);

    Employee retrieveEmployeeById (int id);

    boolean deleteEmployee (int id);

    Employee modifyEmployee (Employee employee);

    List<Employee> getAllEmployees();

}
