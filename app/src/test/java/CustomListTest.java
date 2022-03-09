import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CustomListTest {

    private CustomList list;

    @Before
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount(); // 4
        list.addCity(new City("Halifax", "NS"));
        assertEquals(listSize+1, list.getCount());
    }

    @Test
    public void testHas() {
        City cityTrue = new City("Calgary", "Alberta");
        list.add(cityTrue);
        City cityFalse = new City("Vancouver", "British Columbia");
        assertTrue(list.hasCity(cityTrue));
        assertFalse(list.hasCity(cityFalse));
    }
}
