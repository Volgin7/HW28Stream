package pro.sky.employeeapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeapplication.model.Employee;
import pro.sky.employeeapplication.service.DepartmentService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService deptService;

    public DepartmentController(DepartmentService deptService) {
        this.deptService = deptService;
    }
    @GetMapping("/all")
    public Optional<List<Employee>> all(@RequestParam int departmentId)
    {
        return deptService.all(departmentId);
    }

    @GetMapping("/min-salary")
    public Optional<Employee> minSalary(@RequestParam int departmentId)
    {
        return deptService.minSalary(departmentId);
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalary(@RequestParam int departmentId)
    {
        return deptService.maxSalary(departmentId);
    }
}
