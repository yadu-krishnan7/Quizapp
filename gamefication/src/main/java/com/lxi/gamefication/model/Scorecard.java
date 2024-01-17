package com.lxi.gamefication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scorecard {
    
    @Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private long rank;

}
