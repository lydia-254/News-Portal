package models;

public class News {
    private int id;
    private String content;
    private int employeeId;
    private int DepartmentId;

    public News(int id,String content,int employeeId,int DepartmentId){
        this.id=id;
        this.content=content;
        this.employeeId=employeeId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

}
