package com.example.routtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    void addTrip(Trip trip);

    List<Trip> findAllById(Long id);

    Optional<Trip> findById(Long id);

    void deleteTripById(Long id);



}
