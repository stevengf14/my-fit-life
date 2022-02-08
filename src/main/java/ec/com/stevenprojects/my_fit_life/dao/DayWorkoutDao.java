package ec.com.stevenprojects.my_fit_life.dao;

import ec.com.stevenprojects.my_fit_life.domain.DayWorkout;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface DayWorkoutDao extends CrudRepository<DayWorkout, Long>{
    
}
