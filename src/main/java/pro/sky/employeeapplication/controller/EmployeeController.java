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

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam long salary) {
        return service.add(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping("/list")
    public Map<String,Employee> list() {
        return service.list();
    }


}
