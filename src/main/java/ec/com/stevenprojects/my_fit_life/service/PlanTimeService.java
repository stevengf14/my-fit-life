package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.domain.PlanTime;
import java.util.List;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface PlanTimeService {
    
    public List<PlanTime> getAll();
    
    public PlanTime getById(Long planTimeId);
    
    public List<PlanTime> getByPlanId(Long planId);
    
    public boolean save(PlanTime planTime);
    
    public boolean delete(PlanTime planTime);
    
}
