package ec.com.stevenprojects.my_fit_life.dao;

import ec.com.stevenprojects.my_fit_life.domain.DescriptionWorkout;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface DescriptionWorkoutDao extends CrudRepository<DescriptionWorkout, Long> {
    
}
