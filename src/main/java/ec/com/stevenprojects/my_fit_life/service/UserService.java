package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.domain.User;
import java.util.List;

/**
 *
 * @author Steven Guamán - January 2022
 */
public interface UserService {

    public List<User> getAll();

    public User getById(Long userId);
    
    public User getByUsername(String username);

    public boolean create(User user);
    
    public boolean update(User user);
    
}
