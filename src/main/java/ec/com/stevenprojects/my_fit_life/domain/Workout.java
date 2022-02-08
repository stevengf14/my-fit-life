package ec.com.stevenprojects.my_fit_life.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Steven Guamán - February 2022
 */
@Data
@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutId;

    @NotEmpty
    private String workoutName;

    @NotEmpty
    private String workoutNotes;
    
    @ManyToOne
    @JoinColumn(name = "week_workout_id")
    private WeekWorkout weekWorkout;
    
    @ManyToOne
    @JoinColumn(name = "day_workout_id")
    private DayWorkout dayWorkout;
}
