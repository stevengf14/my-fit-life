package ec.com.stevenprojects.my_fit_life.dao;

import ec.com.stevenprojects.my_fit_life.domain.Plan;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface PlanDao extends CrudRepository<Plan, Long>{
    
}
