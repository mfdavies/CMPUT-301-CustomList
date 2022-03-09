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
        list.addCity(cityTrue);
        City cityFalse = new City("Vancouver", "British Columbia");
        assertTrue(list.hasCity(cityTrue));
        assertFalse(list.hasCity(cityFalse));
    }

    @Test
    public void testDelete() {
        int numCities =  list.getCount();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertEquals(numCities + 1, list.getCount());
        assertTrue(list.hasCity(city));
        list.deleteCity(city);
        assertEquals(numCities, list.getCount());
        assertFalse(list.hasCity(city));
    }

    @Test
    public void testCount() {
        int numCities =  list.getCount();
        City city1 = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city1);
        assertEquals(numCities + 1, list.countCities());
        City city2 = new City("Yellowknife", "Northwest Territories");
        list.addCity(city2);
        assertEquals(numCities + 2, list.countCities());
        list.deleteCity(city1);
        assertEquals(numCities + 1, list.countCities());
    }
}
