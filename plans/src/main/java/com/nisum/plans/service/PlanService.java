package com.nisum.plans.service;

import com.nisum.plans.dao.PlanRepository;
import com.nisum.plans.model.Plan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> getPlans() {
        return planRepository.findAll();
    }

    public Plan getPlanById(Long id){
        return planRepository.findById(id).orElse(null);
    }

    public Plan createPlan(Plan plan){
        return planRepository.save(plan);
    }

    public Plan updatePlan(Long id , Plan plan){
        if(planRepository.existsById(id)){
            plan.setPlanId(id);
            return planRepository.save(plan);
        }
        return null;
    }

    public void deletePlanById(Long id){
        if(planRepository.existsById(id)) {
            planRepository.deleteById(id);
        }else {
            System.out.println("Plan with " + id + "DoesNotExits");
        }
//        return "Plan deleted Successfully";
    }
}
