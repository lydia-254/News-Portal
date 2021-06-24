package models;

public class News {
    private int id;
    private String content;
    private int userId;
    private int DepartmentId;

    public News(int id,String content,int userId,int DepartmentId){
        this.id=id;
        this.content=content;
        this.userId=userId;
        this.DepartmentId=DepartmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }
}
