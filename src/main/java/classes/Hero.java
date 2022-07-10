package classes;

public class Hero  {
    String name;
    String description;
    Integer id;

    public Hero(String name, String description, Integer id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }
    public Hero() {
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Integer getId() {
        return id;
    }

}
