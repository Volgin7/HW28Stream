package pro.sky.employeeapplication.service;

import org.springframework.stereotype.Service;
import pro.sky.employeeapplication.exception.EmployeeNotFoundException;
import pro.sky.employeeapplication.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Optional<List<Employee>> all(int departmentId) {

        List<Employee> employees = new ArrayList<>(employeeServiceImpl.getEmployees().values());
        Optional <List<Employee>> employeesInDepartment = Optional.of(employees.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList()));
        if(employeesInDepartment.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employeesInDepartment;
    }

    @Override
    public Optional<Employee> minSalary(int departmentId) {
        List<Employee> employees = new ArrayList<>(employeeServiceImpl.getEmployees().values());
        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparing(Employee::getSalary));
        if(employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Optional<Employee> maxSalary(int departmentId) {
        List<Employee> employees = new ArrayList<>(employeeServiceImpl.getEmployees().values());
        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparing(Employee::getSalary));
        if(employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Optional<Map<Integer,List<Employee>>> listByDepartments() {
        List<Employee> employees = new ArrayList<>(employeeServiceImpl.getEmployees().values());
        Optional <Map<Integer, List<Employee>>> mapEmployees = Optional.of(employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId)));
        if(mapEmployees.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return mapEmployees;
    }
}
