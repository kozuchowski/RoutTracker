package com.example.routtracker.service;


import com.example.routtracker.model.Trip;
import com.example.routtracker.repository.TripRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository repository;

    public TripService(TripRepository repository) {
        this.repository = repository;
    }

    public void addTrip (Trip trip){
        repository.save(trip);
    }

    public void deleteTrip (Long id){
        repository.deleteTripById(id);
    }

    public Optional<Trip> getTrip (Long id){
        return repository.findById(id);
    }

    public List<Trip> getAllTrips (){
      return repository.findAll();
    }

    public BigDecimal getSumWithinLastWeek(){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime weekAgo = today.minusDays(7);
        return repository.getAmountSumWithinCustomPeriod(weekAgo, today);
    }

    public BigDecimal getSumWithinCustomPeriod (LocalDateTime start, LocalDateTime end){
       return repository.getAmountSumWithinCustomPeriod(start, end);

    }

    public List<Map<LocalDateTime, BigDecimal>> getLastWeekAmountSumByDay () {
        LocalDateTime startDate = LocalDateTime.now().minusDays(8);
        return repository.getLastWeekAmountSumByDay(startDate);
    }


}
