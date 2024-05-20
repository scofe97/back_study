import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionInterfacesTest {

    @Test
    @DisplayName("배열")
    public void array() {
        String[] names = {"matthew", "marin", "phillip"};
        assertEquals("marin", names[1]);
    }

    @Test
    @DisplayName("iterable")
    public void iterable() {
        Iterable<String> iter = Arrays.asList("matthew", "marin", "phillip");
        iter.forEach(System.out::println);
    }

    // collection
    @Test
    @DisplayName("Collection")
    public void collection() {
        Collection<String> collection = new ArrayList<>();
        collection.add("matthew");
        assertTrue(collection.contains("matthew"));
        assertFalse(collection.contains("john"));

    }

    // List
    @Test
    @DisplayName("list")
    public void list() {
        var names = new ArrayList<String>();
        names.addAll(List.of("mathew", "tomas", "minjun"));
        assertEquals("minjune", names.get(2));
    }


    // Set
    @Test
    @DisplayName("set")
    public void set() {
        var coupons = new HashSet<String>();
        coupons.addAll(List.of("matthew", "tomas", "minjun", "matthew"));
        assertEquals(3, coupons.size());
    }

    // Map
    @Test
    @DisplayName("map")
    public void map() {
        HashMap<String, String> persons = new HashMap<>();
        persons.put("a102", "june");
        assertEquals("june", persons.get("a102"));
    }
}
