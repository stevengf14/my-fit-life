package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.domain.DescriptionWorkout;
import java.util.List;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface DescriptionWorkoutService {

    public List<DescriptionWorkout> getAll();

    public DescriptionWorkout getById(Long descriptionWorkoutId);

    public boolean save(DescriptionWorkout descriptionWorkout);

    public boolean delete(DescriptionWorkout descriptionWorkout);

}
