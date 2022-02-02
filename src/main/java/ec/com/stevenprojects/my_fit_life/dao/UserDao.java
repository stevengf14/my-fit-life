package ec.com.stevenprojects.my_fit_life.dao;

import ec.com.stevenprojects.my_fit_life.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steven Guamán - January 2022
 */
public interface UserDao extends CrudRepository<User, Long>{
    
}
