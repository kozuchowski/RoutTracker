package com.example.routtracker.controller;

import com.example.routtracker.model.Trip;
import com.example.routtracker.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class TripsController {

    private final TripRepository repository;

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
        Optional<Trip> optionalTrip = repository.findById(id);

        return optionalTrip.orElse(new Trip("none", "none", new BigDecimal(0)));

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

    @GetMapping("/customPeriodAmountSum")
    public BigDecimal getCustomPeriodAmountSum(@RequestParam("start") String start, @RequestParam("end") String end ){

       return repository.getAmountSumWithinCustomPeriod(LocalDateTime.parse(start), LocalDateTime.parse(end));
    }

    @GetMapping("/lastWeekAmountSum")
    public BigDecimal getlastWeekAmountSum(){
        LocalDateTime start = LocalDateTime.now().minusDays(7);
        LocalDateTime end = LocalDateTime.now();
        return repository.getAmountSumWithinCustomPeriod(start, end);
    }


    @Autowired
    public TripsController(TripRepository repository) {
        this.repository = repository;
    }
}
