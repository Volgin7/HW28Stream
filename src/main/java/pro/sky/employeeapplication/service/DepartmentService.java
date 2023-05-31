package pro.sky.employeeapplication.service;

import pro.sky.employeeapplication.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface DepartmentService {

    Optional<List<Employee>> all(int departmentId);
    Optional<Employee> minSalary(int departmentId);
    Optional<Employee> maxSalary(int departmentId);
    Optional<Map<Integer,List<Employee>>> listByDepartments();
}
