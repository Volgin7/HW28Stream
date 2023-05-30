package pro.sky.employeeapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import pro.sky.employeeapplication.model.Employee;
import pro.sky.employeeapplication.service.EmployeeService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId, @RequestParam long salary) {
        return empService.add(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return empService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return empService.find(firstName, lastName);
    }

    @GetMapping("/list")
    public Map<String,Employee> list() {
        return empService.list();
    }

    @GetMapping("/salary")
    public Employee setSalary(@RequestParam String firstName, @RequestParam String lastName, @RequestParam long salary) {
        return empService.setSalary(firstName, lastName, salary);
    }
    @GetMapping("/department")
    public Employee setDepartment(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId) {
        return empService.setDepartmentId(firstName, lastName, departmentId);
    }

}
