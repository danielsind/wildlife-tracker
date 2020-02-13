public class Endangered extends Animals {
    public boolean endangeredAnimal;
    private String health;
    public String age;

    public Endangered(String animalName,String health,String age){
        this.animalName = animalName;
        this.animalId = animalId;
        this.health = health;
        this.age = age;
    }
    public String getHealth(){
        return health;
    }
    public String getAge(){
        return age;
    }
}
