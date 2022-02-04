package ec.com.stevenprojects.my_fit_life.domain;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Steven Guamán - January 2022
 */
@Data
@Entity
@Table(name = "user")
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String status;

    private Timestamp created;

    private Timestamp updated;

//    @OneToMany
//    @JoinColumn(name="user_id")
//    private List<Role> roles;
}
