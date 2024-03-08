package com.example.lab8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @BeforeEach
    public void setUp() {
        list = new CustomList(null, new ArrayList<>());
    }

    private CustomList MockCityList() {
        return list;
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(listSize + 1, list.getCount(), "Adding a city should increase list size by 1");
    }

    @Test
    public void testHasCity() {
        CustomList list = MockCityList();
        list.addCity(new City("Saskatoon", "SK"));
        assertTrue(list.hasCity(new City("Saskatoon", "SK")));
        assertFalse(list.hasCity(new City("Regina", "SK")));
    }

    @Test
    public void testDeleteCity() {
        CustomList list = MockCityList();
        City cityToAdd = new City("Saskatoon", "SK");
        list.addCity(cityToAdd);
        assertTrue(list.hasCity(cityToAdd));
        list.deleteCity(cityToAdd);
        assertFalse(list.hasCity(cityToAdd));
    }


    @Test
    public void testCountCities() {
        CustomList list = MockCityList();
        assertEquals(0, list.getCount());
        list.addCity(new City("Saskatoon", "SK"));
        assertEquals(1, list.getCount());
    }
}

