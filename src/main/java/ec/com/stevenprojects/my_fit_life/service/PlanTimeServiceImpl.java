package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.dao.PlanTimeDao;
import ec.com.stevenprojects.my_fit_life.domain.PlanTime;
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
public class PlanTimeServiceImpl implements PlanTimeService {

    @Autowired
    private PlanTimeDao planTimeDao;

    @Override
    public List<PlanTime> getAll() {
        List<PlanTime> planTimes = null;
        try {
            planTimes = (List<PlanTime>) planTimeDao.findAll();
        } catch (Exception e) {
            log.error("Error getting all planTimes: " + e.getMessage());
        }
        return planTimes;
    }

    @Override
    public PlanTime getById(Long planTimeId) {
        PlanTime obtainedPlan = null;
        try {
            obtainedPlan = planTimeDao.findById(planTimeId).orElse(null);
        } catch (Exception e) {
            log.error("Error getting planTime with id: " + planTimeId + ": " + e.getMessage());
        }
        return obtainedPlan;
    }

    @Override
    public List<PlanTime> getByPlanId(Long planId) {
        List<PlanTime> obtainedPlanTimess = null;
        try {
            obtainedPlanTimess = planTimeDao.findByPlanId(planId);
        } catch (Exception e) {
            log.error("Error getting planTime with planId: " + planId + ": " + e.getMessage());
        }
        return obtainedPlanTimess;
    }

    @Override
    public boolean save(PlanTime planTime) {
        boolean success = false;
        try {
            planTimeDao.save(planTime);
            success = true;
        } catch (Exception e) {
            log.error("Error saving planTime: " + e.getMessage());
        }
        return success;
    }

    @Override
    public boolean delete(PlanTime planTime) {
        boolean success = false;
        try {
            planTimeDao.delete(planTime);
            success = true;
        } catch (Exception e) {
            log.error("Error deleting planTime: " + e.getMessage());
        }
        return success;
    }
}
