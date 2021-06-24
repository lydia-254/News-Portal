package dao;

import models.Departments;
import models.Employee;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import org.sql2o.Connection;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{
    private Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o){
        this.sql2o=sql2o;
    }

    @Override
    public void add(Departments departments) {
        String sql = "INSERT INTO departments (name, description) VALUES (:name, :description)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            Departments.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void addDepartmentEmployee(Departments departments, Employee employee) {

    }

    @Override
    public List<Departments> getAll() {
        return null;
    }


    @Override
    public List<Employee> getAllDepartmentEmployee(int departmentId) {
        return null;
    }

    @Override
    public Departments findById(int id) {
        return null;
    }

    @Override
    public void update(Departments departments, int id, String name, int num_members) {

    }

    @Override
    public void clearAll() {

    }
}
