import org.sql2o.*;
import java.util.List;

public class Sighting {
    private int animalId;
    private String location;
    private String rangerName;
    private int id;

    public Sighting(int animalId, String location, String rangerName) {
        this.animalId = animalId;
        this.location = location;
        this.rangerName = rangerName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    @Override
    public boolean equals(Object otherSighting) {
        if(!(otherSighting instanceof Sighting)) {
            return false;
        } else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getAnimalId() == (newSighting.getAnimalId()) && this.getLocation().equals(newSighting.getLocation()) && this.getRangerName().equals(newSighting.getRangerName());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animal_id, location, ranger_name) VALUES (:animal_id, :location, :ranger_name);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_id", this.animalId)
                    .addParameter("location", this.location)
                    .addParameter("ranger_name", this.rangerName)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sighting> all() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings;";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }

    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id=:id;";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

}
