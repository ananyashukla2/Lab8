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
    public void testHasCity_True() {
        list.addCity(new City("Edmonton", "AB"));
        assertTrue(list.hasCity(new City("Edmonton", "AB")), "List should contain Edmonton, AB");
    }

    @Test
    public void testHasCity_False() {
        assertFalse(list.hasCity(new City("Calgary", "AB")), "List should not contain Calgary, AB");
    }

    @Test
    public void testDeleteCity_ExistingCity() {
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.deleteCity(city), "Deletion should return true for existing city");
        assertFalse(list.hasCity(city), "List should not contain Edmonton, AB after deletion");
    }

    @Test
    public void testDeleteCity_NonExistingCity() {
        assertFalse(list.deleteCity(new City("Calgary", "AB")), "Deletion should return false for non-existing city");
    }

    @Test
    public void testCountCities() {
        assertEquals(0, list.getCount(), "Count should return the correct number of cities in the list initially");
        list.addCity(new City("Saskatoon", "SK"));
        assertEquals(1, list.getCount(), "Count should reflect the number of cities after adding one");
    }
}

