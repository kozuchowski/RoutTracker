package com.example.routtracker.controller;

import com.example.routtracker.model.Trip;
import com.example.routtracker.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/api")
public class TripsController {

    @Autowired
    TripRepository repository;

    @PostMapping ("/addTrip")
    public void addTrip (@RequestParam("origin") String origin,
                         @RequestParam("destination") String destination,
                         @RequestParam("amount") BigDecimal amount ){
        Trip trip = new Trip(origin, destination, amount);

        repository.addTrip(trip);
    }

    @GetMapping("/trip")
    public String getTripById (String id){

        return "single trip";
    }

    @GetMapping("/trips")
    public String getAllTrips (){

        return "all trips";
    }

    @GetMapping("/deleteTrip")
    public String deleteTRipById (String id){

        return "single trip";
    }
}
