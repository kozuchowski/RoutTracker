package com.example.routtracker.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Trip {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String originAddress;
    @Column
    private String destinationAddress;
    @Column
    private BigDecimal amount;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }

    public Trip(String originAddress, String destinationAddress, BigDecimal amount) {
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.amount = amount;
    }
}
