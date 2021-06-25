package dao;

import models.Departments;
import models.Employee;
import org.sql2o.Sql2o;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oEmployeeDao implements EmployeeDao {

    private Sql2o sql2o;

    public Sql2oEmployeeDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO employees(name,position,role,departmentId) VALUES( :name, :position,:role, :departmentId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(employee)
                    .executeUpdate()
                    .getKey();
            employee.setId(id);
        }
    }

    @Override
    public void addDepartmentUser(Employee employee, Departments department) {
        String sql = "INSERT INTO department_employees (departmentId, employeeId) VALUES (:departmentId, :employeeId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentId", department.getId())
                    .addParameter("employeeId", employee.getId())
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Employee.class);
        }
    }

    @Override
    public List<Employee> getAllDepartmentEmployee(int departmentId) {
        List<Employee> employee = new ArrayList();
        String joinQuery = "SELECT employeeId FROM department_employees WHERE departmentId = :departmentId";
        try (Connection con = sql2o.open()) {
            List<Integer> allEmployeeIds = con.createQuery(joinQuery)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Integer.class);
            for (Integer employeeId : allEmployeeIds) {
                String newsQuery = "SELECT * FROM employees WHERE id = :employeeId";
                employee.add(
                        con.createQuery(newsQuery)
                                .addParameter("employeeId", employeeId)
                                .executeAndFetchFirst(Employee.class));
            }
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
        return employee;
    }

    @Override
    public Employee findById(int id) {
        String sql = "SELECT * FROM employees WHERE id = :id ";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Employee.class);
        }
    }


    @Override
    public void update(Employee employee, int id, String name, String position, String role, int departmentId) {
        String sql = "UPDATE employees SET  (name,position,role,departmentId) = ( :name,:position,:role,:departmentId) WHERE id= :id ";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("name", name)
                    .addParameter("position", position)
                    .addParameter("role", role)
                    .addParameter("departmentId", departmentId)
                    .addParameter("id", employee.getId())
                    .executeUpdate();
            employee.setName(name);
            employee.setPosition(position);
            employee.setRole(role);
            employee.setDepartmentId(departmentId);
        }
    }

    @Override
        public void clearAll () {
            String sql = "DELETE FROM users";
            try (Connection con = sql2o.open()) {
                con.createQuery(sql).executeUpdate();
            } catch (Sql2oException ex) {
                System.out.println(ex);

            }
        }

    public void addDepartmentEmployee(Employee employee, Departments departments) {

    }
}


