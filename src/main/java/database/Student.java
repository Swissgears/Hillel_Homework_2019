package database;

public class Student {

    private Integer id;
    private String name;
    private Integer group_id;

    public Student() {
    }

    public Student(Integer id, String name, Integer group_id) {
        this.id = id;
        this.name = name;
        this.group_id = group_id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group_id=" + group_id +
                '}';
    }
}



