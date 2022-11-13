package com.example.routtracker.controllers;

import com.example.routtracker.models.Trip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/api")
public class TripsController {

    @GetMapping("/addTrip")
    public Trip addTrip (){
        BigDecimal amount = new BigDecimal("20");
        Trip trip = new Trip("origin", "destination", amount);
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
