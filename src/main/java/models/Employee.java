package models;

public class Employee {
    private int id;
    private String name;
    private String position;
    private String role;
    private int DepartmentId;

    public Employee(int id,String name,String position,String role,int DepartmentId){
        this.id=id;
        this.name=name;
        this.position=position;
        this.role=role;
        this.DepartmentId=DepartmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }
}
