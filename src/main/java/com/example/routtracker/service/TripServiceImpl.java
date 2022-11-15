package com.example.routtracker.service;

import com.example.routtracker.model.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    @Override
    public List<Trip> getTripsAmountSumWithinLastWeek() {
        List<Trip> trips;
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime dateTimeMinusWeek = dateTime.minusDays(7);
        String querry = "SELECT SUM(amount) FROM trips WHERE created_on BETWEEN " + dateTimeMinusWeek + " AND " + dateTime;


        //TODO finish
        @Query(querry)
        trips;

        return trips;
    }

    @Override
    public List<Trip> getTripsAmountSumWithinCustomPeriod(String startDate, String stopDate) {
        return null;
    }
}
