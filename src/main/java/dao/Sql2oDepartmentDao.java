package dao;

import models.Departments;
import models.Employee;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import org.sql2o.Connection;

import java.util.ArrayList;
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
        String sql = "INSERT INTO department_users (departmentId, userId) VALUES (:departmentId, :userId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentId", departments.getId())
                    .addParameter("userId", employee.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<Departments> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Departments.class);
        }
    }


    @Override
    public List<Employee> getAllDepartmentEmployee(int departmentId) {
        List<Employee> employee = new ArrayList(); //empty list
        String joinQuery = "SELECT userId FROM department_users WHERE departmentId = :departmentId";
        try (Connection con = sql2o.open()) {
            List<Integer> allUserIds = con.createQuery(joinQuery)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Integer.class);
            for (Integer userId : allUserIds){
                String newsQuery = "SELECT * FROM users WHERE id = :userId";
                employee.add(
                        con.createQuery(newsQuery)
                                .addParameter("userId", userId)
                                .executeAndFetchFirst(Employee.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return employee;
    }

    @Override
    public Departments findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }
    }

    @Override
    public void update(Departments departments, int id, String name, int num_members) {
        String sql = "UPDATE departments SET (name, description) = (:name, :description) WHERE id=:id";
        try (Connection con = sql2o.open()) {
            int description = 0;
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("name", name)
                    .addParameter("description", description)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
