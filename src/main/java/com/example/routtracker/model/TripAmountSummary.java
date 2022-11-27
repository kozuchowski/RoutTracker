package com.example.routtracker.model;


import java.math.BigDecimal;
import java.time.LocalDate;



public interface TripAmountSummary {
    LocalDate getDate();
    BigDecimal getAmount();
}
