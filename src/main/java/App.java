import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oEmployeeDao;
import dao.Sql2oNewsDao;
import models.Departments;
import models.Employee;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Sql2oEmployeeDao employeeDao;
        Connection conn;
        Gson gson = new Gson();
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "Access");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        employeeDao = new Sql2oEmployeeDao(sql2o);
        conn = sql2o.open();

        post("/employee/new", "application/json", (req, res) -> {
            Employee employee = gson.fromJson(req.body(), Employee.class);
            employeeDao.add(employee);
            res.status(100);
            res.type("application/json");
            return gson.toJson(employeeDao.getAll());
        });
        get("/employee",(req,res)->{
            res.type("application/json");
            return gson.toJson(employeeDao.getAll());
        });
        get("/employee/:id",(req,res)->{
            res.type("application/json");
            int employeeId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(employeeDao.findById(employeeId));
        });
        post("/news/new", "application/json",(req,res)->{
            News news=gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(100);
            res.type("application/json");
            return gson.toJson(newsDao.getAll());
        });
        get("/news", (req,res)->{
            res.type("application/json");
            return  gson.toJson(newsDao.getAll());
        });
        get("news/:id",(req,res)->{
            res.type("application/json");
            int newsId=Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(newsDao.findById(newsId));
        });
        get("/department", (req,res)->{
            res.type("application/json");
            return  gson.toJson(departmentDao.getAll());
        });
        get("/department/:id",(req,res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findById(departmentId));
        });
        post("/department/:departmentId/news/:newsId","application/json",(req,res)->{
            int departmentId = Integer.parseInt(req.params("departmentId"));
            int newsId = Integer.parseInt(req.params("newsId"));
            Departments departments = departmentDao.findById(departmentId);
            News news = newsDao.findById(newsId);
            if (departments != null && news != null) {
                //both exist and can be associated
                newsDao.addDepartmentNews(news, departments);
                res.status(201);
                return gson.toJson(String.format("Department '%s' and News '%s' have been associated", news.getContent(), departments.getName()));
            } else {
                return null;
            }
        });
        get("/department/:id/news",(req,res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findById(departmentId));
        });
        post("/department/:departmentId/employees/:employeeId","application/json",(req,res)->{
            int departmentId = Integer.parseInt(req.params("departmentId"));
            int employeeId = Integer.parseInt(req.params("employeeId"));
            Departments departments = departmentDao.findById(departmentId);
            Employee employee = employeeDao.findById(employeeId);
            if (departments != null && employee != null) {
                //both exist and can be associated
                employeeDao.addDepartmentEmployee(employee, departments);
                res.status(201);
                return gson.toJson(String.format("Department '%s' and Employee '%s' have been associated", employee.getName(), departments.getName()));
            } else {
                return null;
            }
        });
        get("/department/:id/employees",(req,res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findById(departmentId));
        });

    }
}
