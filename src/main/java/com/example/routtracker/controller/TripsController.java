package com.example.routtracker.controller;

import com.example.routtracker.model.Trip;
import com.example.routtracker.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class TripsController {

    private final TripService service;

    @PostMapping ("/addTrip")
    public Trip addTrip (@RequestParam("origin") String origin,
                         @RequestParam("destination") String destination,
                         @RequestParam("amount") BigDecimal amount ){
        Trip trip = new Trip(origin, destination, amount);
        service.addTrip(trip);

        return trip;
    }

    @GetMapping("/trip")
    public Trip getTripById (@RequestParam("id") Long id){
        Optional<Trip> optionalTrip = service.getTrip(id);

        return optionalTrip.orElse(new Trip("none", "none", new BigDecimal(0)));

    }

    @GetMapping("/trips")
    public List<Trip> getAllTrips (){
        List<Trip> trips = service.getAllTrips();

        return trips;
    }

    @GetMapping("/deleteTrip")
    public String deleteTRipById (@RequestParam("id") Long id){
        service.deleteTrip(id);

        return "Deleted";
    }

    @GetMapping("/customPeriodAmountSum")
    public BigDecimal getCustomPeriodAmountSum(@RequestParam("start") String start, @RequestParam("end") String end ){

       return service.getSumWithinCustomPeriod(LocalDateTime.parse(start), LocalDateTime.parse(end));
    }

    @GetMapping("/lastWeekAmountSum")
    public BigDecimal getlastWeekAmountSum(){
        LocalDateTime start = LocalDateTime.now().minusDays(7);
        LocalDateTime end = LocalDateTime.now();
        return service.getSumWithinCustomPeriod(start, end);
    }


    @Autowired
    public TripsController(TripService service) {
        this.service = service;
    }
}
