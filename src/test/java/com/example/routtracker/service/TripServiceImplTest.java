package com.example.routtracker.service;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TripServiceImplTest {



    @Test
    void shouldReturnTrip() {
=======
import com.example.routtracker.models.Trip;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TripServiceImplTest {

    @Autowired
    private TripService service;

    @Test
    void shouldReturnTrip() {
        Trip trip = new Trip("start", "stop", new BigDecimal("0"));
>>>>>>> 4a79111564b9de4cb81a2fb347c0e29334283cfe
        assertEquals(1, 1);
    }

}