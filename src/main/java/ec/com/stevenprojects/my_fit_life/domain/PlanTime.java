package ec.com.stevenprojects.my_fit_life.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Steven Guamán - February 2022
 */
@Data
@Entity
@Table(name = "plan_time")
public class PlanTime {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planTimeId;
    
    @DecimalMin(value = "0.0")
    @Digits(integer=10, fraction=2)
    private BigDecimal price;
    
    @NotEmpty
    private String timePeriod;
    
    @NotEmpty
    private String planTimeDescription;
    
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;
    
}
