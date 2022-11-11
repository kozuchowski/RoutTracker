package com.example.routtracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Trip {
    private String originAddress;
    private String destinationAddress;
    private BigDecimal amount;
}
