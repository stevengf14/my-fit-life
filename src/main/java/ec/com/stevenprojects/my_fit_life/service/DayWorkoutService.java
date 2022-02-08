package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.domain.DayWorkout;
import java.util.List;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface DayWorkoutService {

    public List<DayWorkout> getAll();

    public DayWorkout getById(Long dayWorkoutId);

    public boolean save(DayWorkout dayWorkout);

    public boolean delete(DayWorkout dayWorkout);

}
