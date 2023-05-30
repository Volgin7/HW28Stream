package pro.sky.employeeapplication.service;

import org.springframework.stereotype.Service;
import pro.sky.employeeapplication.exception.EmployeeAlreadyAddedException;
import pro.sky.employeeapplication.exception.EmployeeNotFoundException;
import pro.sky.employeeapplication.exception.StorageFullException;
import pro.sky.employeeapplication.model.Employee;

import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String,Employee> employees;
    private final int MAX_NUMBER_OF_EMPLOYEES = 6;

    public int getMAX_NUMBER_OF_EMPLOYEES() {

        return MAX_NUMBER_OF_EMPLOYEES;
    }

    public  EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }
    @Override
    public Employee add(String firstName, String lastName, int department, long salary) {
        if(this.employees.size()>=this.getMAX_NUMBER_OF_EMPLOYEES()) {
            throw new StorageFullException();
        }
        String key = lastName + firstName;
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        String key = lastName + firstName;
        if (employees.containsKey(key)) {
            Employee employee = new Employee(firstName, lastName, employees.get(key).getDepartment(), employees.get(key).getSalary());
            employees.remove(key);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = lastName + firstName;
        if (employees.containsKey(key)) {
            Employee employee = new Employee(firstName, lastName, employees.get(key).getDepartment(), employees.get(key).getSalary());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<String, Employee> list() {
        return new HashMap<>(employees);
    }

}
