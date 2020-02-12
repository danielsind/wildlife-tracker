import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class AnimalTest {
    @Test
    public void animalIsInstantiatedCorrectly_true(){
        Animal testAnimal = new Animal("Lion");
        assertEquals(true,testAnimal instanceof Animal);
    }

    @Test
    public void getAnimalName_getsTheNameOf_theAnimal(){
        Animal testAnimal = new Animal("Lion");
        assertEquals("Lion",testAnimal.getAnimalName());
    }

    @Test
    public void returnTrueIfNameOfTwoAnimalsIsTheSame(){
        Animal firstLion = new Animal("Lion");
        Animal secondLion = new Animal("Lion");
        assertTrue(firstLion.equals(secondLion));
    }
}
