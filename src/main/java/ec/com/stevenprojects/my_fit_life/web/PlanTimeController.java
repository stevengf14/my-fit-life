package ec.com.stevenprojects.my_fit_life.web;

import ec.com.stevenprojects.my_fit_life.domain.PlanTime;
import ec.com.stevenprojects.my_fit_life.service.PlanTimeService;
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
 * @author teven Guamán - February 2022
 */
@RestController
@Slf4j
@RequestMapping("/planTime")
public class PlanTimeController {

    @Autowired
    private PlanTimeService planTimeService;
    
    @GetMapping("/getAll")
    public ResponseEntity getAll(PlanTime planTime) {
        List<PlanTime> planTimes = planTimeService.getAll();
        return ResponseEntity.ok(planTimes);
    }

    @GetMapping("/getById/{planTimeId}")
    public ResponseEntity get(@PathVariable("planTimeId") Long planTimeId) {
        PlanTime planTime = planTimeService.getById(planTimeId);
        if (planTime != null) {
            return ResponseEntity.ok(planTime);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlanTime with id: " + planTimeId + " Not Found");
        }
    }

    @GetMapping("/getByPlanId/{planId}")
    public ResponseEntity getByPlanId(@PathVariable("planId") Long planId) {
        List<PlanTime> planTimes = planTimeService.getByPlanId(planId);
        if (planTimes != null) {
            return ResponseEntity.ok(planTimes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlanTimes with planId: " + planId + " Not Found");
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody PlanTime planTime) {
        if (planTimeService.save(planTime)) {
            // planTime = planTimeService.getById(planTime.getPlanTimeId());
            return ResponseEntity.ok(planTime);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlanTime body is wrong: " + planTime);
        }
    }

    @PostMapping("/update/{planTimeId}")
    public ResponseEntity update(@PathVariable("planTimeId") Long planTimeId, @RequestBody PlanTime planTime) {
        PlanTime planTimeToEdit = planTimeService.getById(planTimeId);
        if (planTime.getPrice() != null) {
            planTimeToEdit.setPrice(planTime.getPrice());
        }
        if (planTime.getTimePeriod() != null) {
            planTimeToEdit.setTimePeriod(planTime.getTimePeriod());
        }
        if (planTime.getPlanTimeDescription() != null) {
            planTimeToEdit.setPlanTimeDescription(planTime.getPlanTimeDescription());
        }
        if (planTime.getPlan() != null) {
            planTimeToEdit.setPlan(planTime.getPlan());
        }
        if (planTimeService.save(planTimeToEdit)) {
            return ResponseEntity.ok(planTimeToEdit);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlanTime body is wrong: " + planTime);
        }
    }

    @DeleteMapping("/delete/{planTimeId}")
    public ResponseEntity create(@PathVariable("planTimeId") Long planTimeId) {
        PlanTime planTimeToDelete = planTimeService.getById(planTimeId);
        if (planTimeService.delete(planTimeToDelete)) {
            return ResponseEntity.ok("PlanTime deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PlanTime Not Found");
        }
    }
}
