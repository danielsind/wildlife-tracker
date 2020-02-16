import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void animalIsInstantiatedCorrectly_true() {
        Animal testAnimal = new Animal("Lion", 1);
        assertEquals(true, testAnimal instanceof Animal);

    }

    @Test
    public void getAnimalName_getsTheNameOf_theAnimal() {
        Animal testAnimal = new Animal("Lion", 1);
        assertEquals("Lion", testAnimal.getName());
    }

    @Test
    public void returnTrueIfNameOfTwoAnimalsIsTheSame() {
        Animal firstLion = new Animal("Lion", 1);
        Animal secondLion = new Animal("Lion", 1);
        assertTrue(firstLion.getName().equals(secondLion.getName()));
    }

    @Test
    public void saveObjectAndSaveToDataBase() {
        Animal testAnimal = new Animal("Lion", 1);
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void all_instancesOfHero_areReturned_true() {
        Animal firstAnimal = new Animal("Lion", 1);
        firstAnimal.save();
        Animal secondAnimal = new Animal("Zebra", 1);
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = new Animal("Deer", 1);
        firstAnimal.save();
        Animal secondAnimal = new Animal("Black Bear", 2);
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void delete_deletesAnimalFromDatabase_0() {
        Animal testAnimal = new Animal("Deer", 1);
        testAnimal.save();
        testAnimal.delete();
        assertEquals(0, Animal.all().size());
    }
}

