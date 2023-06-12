package pro.sky.employeeapplication.model;

import org.apache.commons.lang3.StringUtils;
import pro.sky.employeeapplication.exception.EmployeeBadNameException;

import java.util.Objects;


public class Employee {
    private final String firstName;
    private final String lastName;
    private int departmentId;
    private long salary; // in cents

    public Employee(String firstName, String lastName, int departmentId, long salary) {

        if(!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new EmployeeBadNameException();
        }

        this.firstName = StringUtils.capitalize(firstName);
        this.lastName = StringUtils.capitalize(lastName);
        this.departmentId = departmentId;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", salary=" + salary +
                '}';
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public long getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
