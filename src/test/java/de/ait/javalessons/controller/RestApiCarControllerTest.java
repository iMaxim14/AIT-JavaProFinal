package de.ait.javalessons.controller;

import de.ait.javalessons.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestApiCarControllerTest {

    private RestApiCarController restApiCarController;

    @BeforeEach
    public void setUp(){
        restApiCarController = new RestApiCarController();
    }

    @Test
    void testGetCarsReturnDefaultCars(){
        Iterable<Car> resultCarsIterable = restApiCarController.getCars();
        List<Car> resultCars = new ArrayList<>();
        resultCarsIterable.forEach(resultCars::add);

        assertEquals(4, resultCars.size());
        assertEquals("BMW M1", resultCars.get(0).getName());
    }

    @Test
    void testGetCarByIdWasFound(){
        Optional<Car> result = restApiCarController.getCarById("1");
        assertTrue(result.isPresent());
        assertEquals("BMW M1", result.get().getName());
    }

    @Test
    void testGetCarByIdWasNotFound(){
        Optional<Car> result = restApiCarController.getCarById("10");
        assertFalse(result.isPresent());
    }

    @Test
    void testPostCarAddNewCar(){
        Car carToAdd = new Car("5", "Tesla Model 1");
        Car result = restApiCarController.postCar(carToAdd);
        assertEquals("Tesla Model 1", result.getName());
        assertEquals("5", result.getId());

        Iterable<Car> resultCarsIterable = restApiCarController.getCars();
        List<Car> resultCars = new ArrayList<>();
        resultCarsIterable.forEach(resultCars::add);
        assertEquals(5, resultCars.size());
    }

    @Test
    void testPutCarUpdateCarInfo(){
        Car carToUpdate = new Car("1", "Tesla Model 1");
        ResponseEntity<Car> responseEntityResult = restApiCarController.putCar("1", carToUpdate);
        assertEquals(200, responseEntityResult.getStatusCodeValue());
        assertEquals("Tesla Model 1", responseEntityResult.getBody().getName());
    }

    @Test
    void testPutCarCreateNewCarInfo(){
        Car carToUpdate = new Car("10", "Tesla Model 1");
        ResponseEntity<Car> responseEntityResult = restApiCarController.putCar("10", carToUpdate);
        assertEquals(201, responseEntityResult.getStatusCodeValue());
        assertEquals("Tesla Model 1", responseEntityResult.getBody().getName());
    }

    @Test
    void testDeleteCar(){
        Iterable<Car> resultCarsIterable = restApiCarController.getCars();
        List<Car> resultCars = new ArrayList<>();
        resultCarsIterable.forEach(resultCars::add);
        assertEquals(4, resultCars.size());
        restApiCarController.deleteCar("1");

        //Создаем новую коллекцию, иначе resultCars.size() суммируется
        Iterable<Car> resultCarsIterableDeletedCar = restApiCarController.getCars();
        resultCars = new ArrayList<>();
        resultCarsIterableDeletedCar.forEach(resultCars::add);
        assertEquals(3, resultCars.size());
    }
}
