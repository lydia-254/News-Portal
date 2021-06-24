package dao;

import models.Departments;
import models.Employee;

import java.util.List;

public interface DepartmentDao {
    //CREATE
    void add(Departments departments);
    void addDepartmentEmployee(Departments departments, Employee employee);

    //READ
    List<Departments> getAll();
    List<Employee>getAllDepartmentEmployee(int departmentId);

    Departments findById(int id);

    //UPDATE
    void update(Departments departments, int id,String name, int num_members);

    //DELETE
    void clearAll();
}
