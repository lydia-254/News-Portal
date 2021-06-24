package models;

public class Employee {
    private int id;
    private String name;
    private String position;
    private String role;
    private int DepartmentId;

    public Employee(int id,String name,String position,String role,int DepartmentId){
        this.id=id;
        this.position=position;
        this.role=role;
    }
}
