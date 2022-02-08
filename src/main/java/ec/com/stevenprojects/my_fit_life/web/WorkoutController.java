package ec.com.stevenprojects.my_fit_life.web;

import ec.com.stevenprojects.my_fit_life.domain.DayWorkout;
import ec.com.stevenprojects.my_fit_life.domain.DescriptionWorkout;
import ec.com.stevenprojects.my_fit_life.domain.WeekWorkout;
import ec.com.stevenprojects.my_fit_life.domain.Workout;
import ec.com.stevenprojects.my_fit_life.service.DayWorkoutService;
import ec.com.stevenprojects.my_fit_life.service.DescriptionWorkoutService;
import ec.com.stevenprojects.my_fit_life.service.WeekWorkoutService;
import ec.com.stevenprojects.my_fit_life.service.WorkoutService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Steven Guamán - February 2022
 */
@RestController
@Slf4j
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private DayWorkoutService dayWorkoutService;

    @Autowired
    private WeekWorkoutService weekWorkoutService;

    @Autowired
    private DescriptionWorkoutService descriptionWorkoutService;

    @GetMapping("/getAll")
    public ResponseEntity getAll(Workout workout) {
        List<Workout> workouts = workoutService.getAll();
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/getById/{workoutId}")
    public ResponseEntity get(@PathVariable("workoutId") Long workoutId) {
        Workout workout = workoutService.getById(workoutId);
        if (workout != null) {
            return ResponseEntity.ok(workout);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workout with id: " + workoutId + " Not Found");
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Workout workout) {
        System.out.println("********************Workout: " + workout);
        // day workout description
        DescriptionWorkout descriptionWorkout = new DescriptionWorkout();
        descriptionWorkout.setDescriptionWorkoutName(workout.getDayWorkout().getDescriptionWorkout().getDescriptionWorkoutName());
        descriptionWorkout.setDescriptionWorkoutDescription(workout.getDayWorkout().getDescriptionWorkout().getDescriptionWorkoutDescription());
        if (descriptionWorkoutService.save(descriptionWorkout)) {
            // day workout
            //descriptionWorkout = descriptionWorkoutService.get
            DayWorkout dayWorkout = new DayWorkout();
            dayWorkout.setDayWorkoutName(workout.getDayWorkout().getDayWorkoutName());
            dayWorkout.setDayWorkoutObservation(workout.getDayWorkout().getDayWorkoutObservation());
            dayWorkout.setDescriptionWorkout(descriptionWorkout);
            if (dayWorkoutService.save(dayWorkout)) {
                // week workout 
                WeekWorkout weekWorkout = new WeekWorkout();
                weekWorkout.setWeekWorkoutName(workout.getWeekWorkout().getWeekWorkoutName());
                weekWorkout.setWeekWorkoutDescription(workout.getWeekWorkout().getWeekWorkoutDescription());
                if (weekWorkoutService.save(weekWorkout)) {
                    if (workoutService.save(workout)) {
                        return ResponseEntity.ok(workout);
                    } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workout body is wrong: " + workout);
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workout body is wrong: " + workout);
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workout body is wrong: " + workout);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workout body is wrong: " + workout);
        }
    }
}
