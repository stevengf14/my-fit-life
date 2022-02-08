package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.domain.WeekWorkout;
import java.util.List;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface WeekWorkoutService {
    
    public List<WeekWorkout> getAll();

    public WeekWorkout getById(Long weekWorkoutId);

    public boolean save(WeekWorkout weekWorkout);

    public boolean delete(WeekWorkout weekWorkout);
    
}
