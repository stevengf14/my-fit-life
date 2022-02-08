package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.domain.Role;
import java.util.List;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface RoleService {

    public List<Role> getAll();

    public Role getById(Long roleId);

    public boolean save(Role role);

}
