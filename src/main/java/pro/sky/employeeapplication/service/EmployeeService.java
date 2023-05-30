package pro.sky.employeeapplication.service;

import pro.sky.employeeapplication.model.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int department, long salary);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Map<String, Employee> list();
}
