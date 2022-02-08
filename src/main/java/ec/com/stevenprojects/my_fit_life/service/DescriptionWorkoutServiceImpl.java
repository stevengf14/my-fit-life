package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.dao.DescriptionWorkoutDao;
import ec.com.stevenprojects.my_fit_life.domain.DescriptionWorkout;
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
public class DescriptionWorkoutServiceImpl implements DescriptionWorkoutService {

    @Autowired
    private DescriptionWorkoutDao descriptionWorkoutDao;

    @Override
    public List<DescriptionWorkout> getAll() {
        List<DescriptionWorkout> descriptions = null;
        try {
            descriptions = (List<DescriptionWorkout>) descriptionWorkoutDao.findAll();
        } catch (Exception e) {
            log.error("Error getting all description workouts: " + e.getMessage());
        }
        return descriptions;
    }

    @Override
    public DescriptionWorkout getById(Long descriptionWorkoutId) {
        DescriptionWorkout obtainedDescription = null;
        try {
            obtainedDescription = descriptionWorkoutDao.findById(descriptionWorkoutId).orElse(null);
        } catch (Exception e) {
            log.error("Error getting description workout with id: " + descriptionWorkoutId + ": " + e.getMessage());
        }
        return obtainedDescription;
    }

    @Override
    public boolean save(DescriptionWorkout descriptionWorkout) {
        boolean success = false;
        try {
            descriptionWorkoutDao.save(descriptionWorkout);
            success = true;
        } catch (Exception e) {
            log.error("Error saving description workout: " + e.getMessage());
        }
        return success;
    }

    @Override
    public boolean delete(DescriptionWorkout descriptionWorkout) {
        boolean success = false;
        try {
            descriptionWorkoutDao.delete(descriptionWorkout);
            success = true;
        } catch (Exception e) {
            log.error("Error deleting description workout: " + e.getMessage());
        }
        return success;
    }

}
