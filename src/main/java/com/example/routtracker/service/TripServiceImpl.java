package com.example.routtracker.service;

import com.example.routtracker.models.Trip;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TripServiceImpl implements TripService{
    @Override
    public Trip addTrip(String start, String destination, BigDecimal amount) {

        System.out.println(start + ", " + destination + ", " + amount);

        return new Trip(start, destination, amount);
    }

    @Override
    public void deleteTrip(int id) {

        System.out.println("deleted Trip with id: " + id);
    }

    @Override
    public Trip getTrip(int id) {

        System.out.println("returns Trip with id: " + id);

        return null;
    }

    @Override
    public List<Trip> getAllTrips() {

        System.out.println("returns all Trips");

        return null;
    }
}
