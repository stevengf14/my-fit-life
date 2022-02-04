package ec.com.stevenprojects.my_fit_life.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Steven Guamán - February 2022
 */
@Data
@Entity
@Table(name = "plan")
public class Plan {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @NotEmpty
    private String planName;
    
    @NotEmpty
    private String planStatus;

    @NotEmpty
    private String planDescription;
    
    @NotEmpty
    private String benefits;

}
