package dao;

import models.Departments;
import models.Employee;
import org.sql2o.Sql2o;

import org.sql2o.Connection;
import java.util.List;

public class Sql2oEmployeeDao implements EmployeeDao{

    private Sql2o sql2o;
    public Sql2oEmployeeDao(Sql2o sql2o){
        this.sql2o=sql2o;
    }


    @Override
    public void add(Employee employee) {
        String sql="INSERT INTO employees(name,position,role,departmentId) VALUES( :name, :position,:role, :departmentId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(employee)
                    .executeUpdate()
                    .getKey();
            employee.setId(id);
        }
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
