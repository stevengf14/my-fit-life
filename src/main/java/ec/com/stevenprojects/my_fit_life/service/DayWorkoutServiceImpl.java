package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.dao.DayWorkoutDao;
import ec.com.stevenprojects.my_fit_life.domain.DayWorkout;
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
public class DayWorkoutServiceImpl implements DayWorkoutService {

    @Autowired
    private DayWorkoutDao dayWorkoutDao;

    @Override
    public List<DayWorkout> getAll() {
        List<DayWorkout> dayWorkouts = null;
        try {
            dayWorkouts = (List<DayWorkout>) dayWorkoutDao.findAll();
        } catch (Exception e) {
            log.error("Error getting all day workouts: " + e.getMessage());
        }
        return dayWorkouts;
    }

    @Override
    public DayWorkout getById(Long dayWorkoutId) {
        DayWorkout obtainedDayWorkout = null;
        try {
            obtainedDayWorkout = dayWorkoutDao.findById(dayWorkoutId).orElse(null);
        } catch (Exception e) {
            log.error("Error getting day workout with id: " + dayWorkoutId + ": " + e.getMessage());
        }
        return obtainedDayWorkout;
    }

    @Override
    public boolean save(DayWorkout dayWorkout) {
        boolean success = false;
        try {
            dayWorkoutDao.save(dayWorkout);
            success = true;
        } catch (Exception e) {
            log.error("Error saving day workout: " + e.getMessage());
        }
        return success;
    }

    @Override
    public boolean delete(DayWorkout dayWorkout) {
        boolean success = false;
        try {
            dayWorkoutDao.delete(dayWorkout);
            success = true;
        } catch (Exception e) {
            log.error("Error deleting day workout: " + e.getMessage());
        }
        return success;
    }

}
