/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.com.stevenprojects.my_fit_life.service;

import ec.com.stevenprojects.my_fit_life.domain.Role;
import java.util.List;

/**
 * 
 * @author Steven Guamán - January 2022
 */
public interface RoleService {
    
    public List<Role> getAll();
    
    public Role getById(Long roleId);
    
    public boolean save(Role role);
    
}
