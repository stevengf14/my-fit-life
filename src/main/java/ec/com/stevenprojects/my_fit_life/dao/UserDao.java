package ec.com.stevenprojects.my_fit_life.dao;

import ec.com.stevenprojects.my_fit_life.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Steven Guamán - January 2022
 */
public interface UserDao extends CrudRepository<User, Long> {

    @Query(value = "SELECT USER_ID, USERNAME, PASSWORD, STATUS, CREATED, UPDATED\n"
            + "FROM user where username = :username", nativeQuery = true)
    public User findByUsername(@Param("username") String username);

}
