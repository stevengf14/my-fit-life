package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.dao.PlanDao;
import ec.com.stevenprojects.my_fit_life.domain.Plan;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steven Guamán - February 2022
 */
@Slf4j
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanDao planDao;

    @Override
    public List<Plan> getAll() {
        List<Plan> plans = null;
        try {
            plans = (List<Plan>) planDao.findAll();
        } catch (Exception e) {
            log.error("Error getting all plans: " + e.getMessage());
        }
        return plans;
    }

    @Override
    public Plan getById(Long planId) {
        Plan obtainedPlan = null;
        try {
            obtainedPlan = planDao.findById(planId).orElse(null);
        } catch (Exception e) {
            log.error("Error getting plan with id: " + planId + ": " + e.getMessage());
        }
        return obtainedPlan;
    }

    @Override
    public boolean save(Plan plan) {
        boolean success = false;
        try {
            planDao.save(plan);
            success = true;
        } catch (Exception e) {
            log.error("Error saving plan: " + e.getMessage());
        }
        return success;
    }

    @Override
    public boolean delete(Plan plan) {
        boolean success = false;
        try {
            planDao.delete(plan);
            success = true;
        } catch (Exception e) {
            log.error("Error deleting plan: " + e.getMessage());
        }
        return success;
    }

}
