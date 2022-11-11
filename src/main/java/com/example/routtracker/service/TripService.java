package com.example.routtracker.service;

import com.example.routtracker.models.Trip;

import java.math.BigDecimal;
import java.util.List;

public interface TripService {

    Trip addTrip(String start, String destination, BigDecimal amount);

    void deleteTrip(int id);

    Trip getTrip (int id);

    List<Trip> getAllTrips ();


}
