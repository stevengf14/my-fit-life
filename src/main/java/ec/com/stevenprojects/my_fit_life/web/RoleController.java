/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.stevenprojects.my_fit_life.web;

import ec.com.stevenprojects.my_fit_life.domain.Role;
import ec.com.stevenprojects.my_fit_life.service.RoleService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Steven Guamán - January 2022
 */
@RestController
@Slf4j
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;
    
    @GetMapping("/getAll")
    public ResponseEntity getAll(Role role) {
        List<Role> roles = roleService.getAll();
        return ResponseEntity.ok(roles);
    }
    
    @GetMapping("/getById/{roleId}")
    public ResponseEntity get(@PathVariable("roleId") Long roleId) {
        Role role = roleService.getById(roleId);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role with id: " + roleId + " Not Found");
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Role role) {
        if (roleService.save(role)) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role body is wrong: " + role);
        }
    }
    
    @PostMapping("/update/{roleId}")
    public ResponseEntity update(@PathVariable("roleId") Long roleId, @RequestBody Role role) {
        Role roleToEdit = roleService.getById(roleId);
        if(role.getRoleName() != null){
            roleToEdit.setRoleName(role.getRoleName());
        }
        if(role.getUser()!= null){
            roleToEdit.setUser(role.getUser());
        }
        if (roleService.save(roleToEdit)) {
            return ResponseEntity.ok(roleToEdit);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role body is wrong: " + role);
        }
    }
    
}
