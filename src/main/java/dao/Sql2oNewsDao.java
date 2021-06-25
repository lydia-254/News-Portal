package dao;

import models.Departments;
import models.Employee;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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
        String sql = "INSERT INTO department_news (departmentId, newsId) VALUES (:departmentId, :newsId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentId", department.getId())
                    .addParameter("newsId", news.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAll() {
        String sql="SELECT * FROM news";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int id) {
        String sql ="SELECT * FROM news WHERE id = :id ";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(News.class);
        }
    }

    @Override
    public void update(News news,int id,String content,int employeeId,int DepartmentId ) {
        String sql="UPDATE news SET(content,employeeId)=(:content,:employeeId) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("content",content)
                    .addParameter("employeeId",employeeId)
                    .executeUpdate();
            news.setContent(content);
            news.setEmployeeId(employeeId);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM news";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
