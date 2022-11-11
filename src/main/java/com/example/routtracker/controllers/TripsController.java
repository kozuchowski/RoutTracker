package com.example.routtracker.controllers;

import com.example.routtracker.models.Trip;
import com.example.routtracker.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/api")
public class TripsController {

    @Autowired
    TripService service;

    @PostMapping ("/addTrip")
    public Trip addTrip (@RequestParam("origin") String origin,
                         @RequestParam("destination") String Destination,
                         @RequestParam("amount") BigDecimal amount ){
        Trip trip = service.addTrip(origin, Destination, amount);

        return trip;
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
