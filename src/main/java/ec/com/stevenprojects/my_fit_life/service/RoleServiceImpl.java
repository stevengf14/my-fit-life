package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.dao.RoleDao;
import ec.com.stevenprojects.my_fit_life.domain.Role;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steven Guamán - February 2022
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getAll() {
        List<Role> roles = null;
        try {
            roles = (List<Role>) roleDao.findAll();
        } catch (Exception e) {
            log.error("Error getting all roles: " + e.getMessage());
        }
        return roles;
    }

    @Override
    public Role getById(Long roleId) {
        Role obtainedRole = null;
        try {
            obtainedRole = roleDao.findById(roleId).orElse(null);
        } catch (Exception e) {
            log.error("Error getting role with id: " + roleId + ": " + e.getMessage());
        }
        return obtainedRole;
    }

    @Override
    public boolean save(Role role) {
        boolean success = false;
        try {
            roleDao.save(role);
            success = true;
        } catch (Exception e) {
            log.error("Error saving role: " + e.getMessage());
        }
        return success;
    }

}
