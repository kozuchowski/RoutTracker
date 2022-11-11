package com.example.routtracker.controllers;

import com.example.routtracker.models.Trip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class TripsController {

    @GetMapping("/addTrip")
    public Trip addTrip (){
        Trip trip = new Trip("origin", "destination", 20);
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
