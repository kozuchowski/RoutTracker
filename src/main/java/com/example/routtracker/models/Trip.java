package com.example.routtracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trip {
    private String originAddress;
    private String destinationAddress;
    private double amount;
}
