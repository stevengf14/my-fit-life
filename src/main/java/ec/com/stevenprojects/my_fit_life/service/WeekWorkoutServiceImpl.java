package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.dao.WeekWorkoutDao;
import ec.com.stevenprojects.my_fit_life.domain.WeekWorkout;
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
public class WeekWorkoutServiceImpl implements WeekWorkoutService {

    @Autowired
    private WeekWorkoutDao weekWorkoutDao;

    @Override
    public List<WeekWorkout> getAll() {
        List<WeekWorkout> weekWorkouts = null;
        try {
            weekWorkouts = (List<WeekWorkout>) weekWorkoutDao.findAll();
        } catch (Exception e) {
            log.error("Error getting all week workouts: " + e.getMessage());
        }
        return weekWorkouts;
    }

    @Override
    public WeekWorkout getById(Long weekWorkoutId) {
        WeekWorkout obtainedWeekWorkout = null;
        try {
            obtainedWeekWorkout = weekWorkoutDao.findById(weekWorkoutId).orElse(null);
        } catch (Exception e) {
            log.error("Error getting week workout with id: " + weekWorkoutId + ": " + e.getMessage());
        }
        return obtainedWeekWorkout;
    }

    @Override
    public boolean save(WeekWorkout weekWorkout) {
        boolean success = false;
        try {
            weekWorkoutDao.save(weekWorkout);
            success = true;
        } catch (Exception e) {
            log.error("Error saving week workout: " + e.getMessage());
        }
        return success;
    }

    @Override
    public boolean delete(WeekWorkout weekWorkout) {
        boolean success = false;
        try {
            weekWorkoutDao.delete(weekWorkout);
            success = true;
        } catch (Exception e) {
            log.error("Error deleting week workout: " + e.getMessage());
        }
        return success;
    }

}
