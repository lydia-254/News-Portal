package dao;

import models.Departments;
import models.Employee;

import java.util.List;

public interface DepartmentDao {
    //CREATE
    void add(Employee employee);
    void addDepartmentUser(Employee employee, Departments department);

    //READ
    List<Employee> getAll();
    List<Employee>getAllDepartmentUser(int departmentId);

    Employee findById(int id);

    //UPDATE
    void update(Employee employee, int id,String name,String position,String role,int departmentId);

    //DELETE
    void clearAll();
}
