import org.sql2o.*;
import java.util.List;


public class Animal extends Animals {

    public Animal(String animalName){
        this.animalName = animalName;
        this.animalId = animalId;
    }
    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)){
            return false;
        }
        else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getAnimalName().equals(newAnimal.getAnimalName());
        }
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.animalId = (int) con.createQuery(sql,true)
                    .addParameter("name", this.animalName)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animal> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals;";
            return con.createQuery(sql)
                    .executeAndFetch(Animal.class);
        }
    }
}
public Animal find(int animalId){
    try(Connection con = DB.sql2o.open()){
        String sql = "SELECT * FROM animals WHERE animalId=:animalId;";
        Animal animal = con.createQuery(sql)
                .addParameter("animalId",animalId)
                .executeAndFetchFirst(Animal.class);
        return animal;
    }
}