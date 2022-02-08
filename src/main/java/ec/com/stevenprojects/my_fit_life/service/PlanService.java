package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.domain.Plan;
import java.util.List;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface PlanService {

    public List<Plan> getAll();

    public Plan getById(Long planId);

    public boolean save(Plan plan);

    public boolean delete(Plan plan);

}
