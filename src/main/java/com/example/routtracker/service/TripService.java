package com.example.routtracker.service;

import com.example.routtracker.model.Trip;

import java.util.List;

public interface TripService {

    List<Trip> getTripsAmountSumWithinLastWeek ();

    List<Trip> getTripsAmountSumWithinCustomPeriod (String startDate, String stopDate);
}
