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
@Table(name = "day_workout")
public class DayWorkout {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayWorkoutId;

    @NotEmpty
    private String dayWorkoutName;

    @NotEmpty
    private String dayWorkoutObservation;

    @ManyToOne
    @JoinColumn(name = "description_workout_id")
    private DescriptionWorkout descriptionWorkout;
    
}
