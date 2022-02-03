package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.dao.RoleDao;
import ec.com.stevenprojects.my_fit_life.dao.UserDao;
import ec.com.stevenprojects.my_fit_life.domain.Role;
import ec.com.stevenprojects.my_fit_life.domain.User;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steven Guamán - January 2022
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<User> getAll() {
        List<User> users = null;
        try {
            users = (List<User>) userDao.findAll();
        } catch (Exception e) {
            log.error("Error getting all users: " + e.getMessage());
        }
        return users;
    }

    @Override
    public User getById(Long userId) {
        User obtainedUser = null;
        try {
            obtainedUser = userDao.findById(userId).orElse(null);
        } catch (Exception e) {
            log.error("Error getting user with id: " + userId + ": " + e.getMessage());
        }
        return obtainedUser;
    }

    @Override
    public User getByUsername(String username) {
        User obtainedUser = null;
        try {
            obtainedUser = userDao.findByUsername(username);
        } catch (Exception e) {
            log.error("Error getting user: " + username + ": " + e.getMessage());
        }
        return obtainedUser;
    }

    @Override
    @Transactional
    public boolean create(User user) {
        boolean success = false;
        try {
            userDao.save(user);
            Role role = new Role();
            role.setRoleName("ROLE_USER");
            role.setUser(user);
            roleDao.save(role);
            success = true;
        } catch (Exception e) {
            log.error("Error saving user: " + e.getMessage());
        }
        return success;
    }

    @Override
    public boolean update(User user) {
        boolean success = false;
        try {
            userDao.save(user);
            success = true;
        } catch (Exception e) {
            log.error("Error saving user: " + e.getMessage());
        }
        return success;
    }

}
