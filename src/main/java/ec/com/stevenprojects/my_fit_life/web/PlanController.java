package ec.com.stevenprojects.my_fit_life.web;

import ec.com.stevenprojects.my_fit_life.domain.Plan;
import ec.com.stevenprojects.my_fit_life.service.PlanService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Steven Guamán - February 2022
 */
@RestController
@Slf4j
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/getAll")
    public ResponseEntity getAll(Plan plan) {
        List<Plan> plans = planService.getAll();
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/getById/{planId}")
    public ResponseEntity get(@PathVariable("planId") Long planId) {
        Plan plan = planService.getById(planId);
        if (plan != null) {
            return ResponseEntity.ok(plan);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan with id: " + planId + " Not Found");
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Plan plan) {
        if (planService.save(plan)) {
            return ResponseEntity.ok(plan);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan body is wrong: " + plan);
        }
    }

    @PostMapping("/update/{planId}")
    public ResponseEntity update(@PathVariable("planId") Long planId, @RequestBody Plan plan) {
        Plan planToEdit = planService.getById(planId);
        if (plan.getPlanName() != null) {
            planToEdit.setPlanName(plan.getPlanName());
        }
        if (plan.getPlanDescription() != null) {
            planToEdit.setPlanDescription(plan.getPlanDescription());
        }
        if (plan.getPlanStatus() != null) {
            planToEdit.setPlanStatus(plan.getPlanStatus());
        }
        if (plan.getBenefits() != null) {
            planToEdit.setBenefits(plan.getBenefits());
        }
        if (planService.save(planToEdit)) {
            return ResponseEntity.ok(planToEdit);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan body is wrong: " + plan);
        }
    }

    @DeleteMapping("/delete/{planId}")
    public ResponseEntity create(@PathVariable("planId") Long planId) {
        Plan planToDelete = planService.getById(planId);
        if (planService.delete(planToDelete)) {
            return ResponseEntity.ok("Plan deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan Not Found");
        }
    }
}
