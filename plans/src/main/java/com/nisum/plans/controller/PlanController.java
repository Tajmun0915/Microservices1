package com.nisum.plans.controller;

import com.nisum.plans.model.Plan;
import com.nisum.plans.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public List<Plan> getAllPlans() {
        return planService.getPlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Long id) {
        Plan plan = planService.getPlanById(id);
        if (plan != null) {
            return ResponseEntity.ok(plan);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Plan> savePlan(@RequestBody Plan plan) {
        Plan createdPlan = planService.createPlan(plan);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> updatePlan(@PathVariable Long id, @RequestBody Plan plan) {
        Plan updatedPlan =  planService.updatePlan(id, plan);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        planService.deletePlanById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Plan deleted Successfully");
    }
}
