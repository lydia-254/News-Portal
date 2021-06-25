package dao;

import models.Departments;
import models.Employee;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{
    private Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(News news) {
        String sql="INSERT INTO news(content,employeeId) VALUES(:content,:employeeId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(news)
                    .executeUpdate().getKey();
            news.setId(id);
        }
    }

    @Override
    public void addDepartmentNews(News news, Departments department) {

    }

    @Override
    public List<News> getAll() {
        String sql="SELECT * FROM news";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(News.class);
        }
    }

    @Override
    public List<News> getAllDepartmentNews(int departmentId) {
        return null;
    }

    @Override
    public News findById(int id) {
        return null;
    }

    @Override
    public void update(News news, int id, String name, String position, String role, int departmentId) {

    }

    @Override
    public void clearAll() {

    }
}
