import org.sql2o.Connection;

import java.util.List;

public class Endangered extends Animals {
    public boolean endangeredAnimal;
    private String health;
    private String age;

    public Endangered(String name , String health,String age){
        this.name = name;
        this.id = id;
        this.age = age;
        this.health = health;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangered_animals (name, health, age) VALUES (:name, :health, :age);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Endangered> all() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangered_animals;";
            return con.createQuery(sql)
                    .executeAndFetch(Endangered.class);
        }
    }

    public static Endangered find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangered_animals WHERE id=:id;";
            Endangered endangered = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Endangered.class);
            return endangered;
        }
    }
}