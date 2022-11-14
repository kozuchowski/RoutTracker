package com.example.routtracker.controller;

import com.example.routtracker.model.Trip;
import com.example.routtracker.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class TripsController {

    @Autowired
    TripRepository repository;

    @PostMapping ("/addTrip")
    public Trip addTrip (@RequestParam("origin") String origin,
                         @RequestParam("destination") String destination,
                         @RequestParam("amount") BigDecimal amount ){
        Trip trip = new Trip(origin, destination, amount);
        repository.save(trip);

        return trip;
    }

    @GetMapping("/trip")
    public Trip getTripById (@RequestParam("id") Long id){
        Optional<Trip> trip = repository.findById(id);

        if(trip.isPresent()){
            return trip.get();
        }
        //I know, I know - muszę przypomnieć sobie optionale i zmienię to ;)
        return null;
    }

    @GetMapping("/trips")
    public List<Trip> getAllTrips (){
        List<Trip> trips = repository.findAll();

        return trips;
    }

    @GetMapping("/deleteTrip")
    public String deleteTRipById (@RequestParam("id") Long id){
        repository.deleteTripById(id);

        return "Deleted";
    }
}
