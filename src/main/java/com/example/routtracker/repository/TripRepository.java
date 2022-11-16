package com.example.routtracker.repository;

import com.example.routtracker.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {


    List<Trip> findAll();

    Optional<Trip> findById(Long id);

    @Transactional
    void deleteTripById(Long id);

    @Query("select sum(t.amount) from Trip t where t.createdOn between  ?1 and ?2")
    BigDecimal getAmountSumWithinCustomPeriod (LocalDateTime startDate, LocalDateTime endDate);



}
