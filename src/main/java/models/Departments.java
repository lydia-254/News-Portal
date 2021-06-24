package models;

public class Departments {
    private int id;
    private String name;
    private int num_members;

    public Departments(int id,String name ,int num_members){
        this.id=id;
        this.name=name;
        this.num_members=num_members;
    }

    public int getId() {
        return id;
    }

    public static void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum_members() {
        return num_members;
    }

    public void setNum_members(int num_members) {
        this.num_members = num_members;
    }
}
