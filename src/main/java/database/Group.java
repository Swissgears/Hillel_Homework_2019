package database;

public class Group {

    private Integer id;
    private String nameGroup;

    public Group(Integer id, String nameGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
    }

    public Group() {

    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                '}';
    }
}


