import org.junit.Rule;
import  org.junit.Test;
import static org.junit.Assert.*;

import javax.xml.crypto.Data;

public class EndangeredTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();
    @Test
    public void Correct_instantiation_OfClass_Endangered_true_Lion_Healthy_Old(){
        Endangered testEndangered = new Endangered("Lion","Healthy","Old");
        assertEquals(true,testEndangered instanceof Endangered);
    }
    @Test
    public void getHealth_returnsHealthAttribute_true() {
        Endangered testEndangered = new Endangered("Rhino", "Healthy", "Young");
        assertEquals("Healthy", testEndangered.getHealth());
    }

    @Test
    public void getHealth_returnsAgeAttribute_true() {
        Endangered testEndangered = new Endangered("Rhino", "Healthy", "Young");
        assertEquals("Young", testEndangered.getAge());
    }
    @Test
    public void save_assignsIdAndSavesObjectToDatabase() {
        Endangered testEndangered = new Endangered("Rhino", "Healthy", "Young");
        testEndangered.save();
        Endangered savedEndangered = Endangered.all().get(0);
        assertEquals(testEndangered.getId(), savedEndangered.getId());
    }




}
