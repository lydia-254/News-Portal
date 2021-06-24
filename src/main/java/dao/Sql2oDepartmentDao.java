package dao;

import models.Departments;
import models.Employee;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void addDepartmentUser(Employee employee, Departments department) {

    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public List<Employee> getAllDepartmentUser(int departmentId) {
        return null;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void update(Employee employee, int id, String name, String position, String role, int departmentId) {

    }

    @Override
    public void clearAll() {

    }
}
