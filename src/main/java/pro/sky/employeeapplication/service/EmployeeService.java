package pro.sky.employeeapplication.service;

import pro.sky.employeeapplication.model.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int departmentID, long salary);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Map<String, Employee> list();
    Employee setSalary(String firstName, String lastName, long salary);
    Employee setDepartmentId(String firstName, String lastName, int departmentId);
}
