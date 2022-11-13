package com.example.routtracker.service;

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
        assertEquals(1, 1);
    }

}