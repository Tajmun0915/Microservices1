package com.nisum.plans.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Plan" , schema = "plandb")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    private String code;
    private String caption;
    private String planPrice;
    private String monthlyCost;
    private int trialDuration;
    private boolean isDiscountedPrice;
}
