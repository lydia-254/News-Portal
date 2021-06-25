package dao;

import models.Departments;
import models.Employee;
import models.News;

import java.util.List;

public interface NewsDao {

    void add(News news);
    void addDepartmentNews(News news, Departments department);


    List<News> getAll();
//    List<News>getAllDepartmentNews(int departmentId);

    News findById(int id);

    void update(News news, int id,String content,int employeeId,int DepartmentId);

    //DELETE
    void clearAll();
}
