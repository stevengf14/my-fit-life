package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.dao.WorkoutDao;
import ec.com.stevenprojects.my_fit_life.domain.Workout;
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
public class WorkoutServiceImpl implements WorkoutService {

    @Autowired
    private WorkoutDao workoutDao;

    @Override
    public List<Workout> getAll() {
        List<Workout> workouts = null;
        try {
            workouts = (List<Workout>) workoutDao.findAll();
        } catch (Exception e) {
            log.error("Error getting all workouts: " + e.getMessage());
        }
        return workouts;
    }

    @Override
    public Workout getById(Long workoutId) {
        Workout obtainedWorkout = null;
        try {
            obtainedWorkout = workoutDao.findById(workoutId).orElse(null);
        } catch (Exception e) {
            log.error("Error getting workout with id: " + workoutId + ": " + e.getMessage());
        }
        return obtainedWorkout;
    }

    @Override
    public boolean save(Workout workout) {
        boolean success = false;
        try {
            workoutDao.save(workout);
            success = true;
        } catch (Exception e) {
            log.error("Error saving workout: " + e.getMessage());
        }
        return success;
    }

    @Override
    public boolean delete(Workout workout) {
        boolean success = false;
        try {
            workoutDao.delete(workout);
            success = true;
        } catch (Exception e) {
            log.error("Error deleting plan: " + e.getMessage());
        }
        return success;
    }

}
