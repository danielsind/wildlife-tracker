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
}
