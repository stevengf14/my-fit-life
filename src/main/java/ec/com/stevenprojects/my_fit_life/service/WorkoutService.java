package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.domain.Workout;
import java.util.List;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface WorkoutService {
    
    public List<Workout> getAll();

    public Workout getById(Long workoutId);

    public boolean save(Workout workout);

    public boolean delete(Workout workout);
    
}
