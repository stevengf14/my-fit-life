package ec.com.stevenprojects.my_fit_life.web;

import ec.com.stevenprojects.my_fit_life.domain.User;
import ec.com.stevenprojects.my_fit_life.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity getAll(User user) {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{userId}")
    public ResponseEntity get(@PathVariable("userId") Long userId) {
        User user = userService.getById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id: " + userId + " Not Found");
        }
    }

    @GetMapping("/getByUsername/{username}")
    public ResponseEntity get(@PathVariable("username") String username) {
        User user = userService.getByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User " + username + " Not Found");
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus("A");
        if (userService.create(user)) {
            user = userService.getById(user.getUserId());
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User body is wrong: " + user);
        }
    }

    @PostMapping("/update/{userId}")
    public ResponseEntity update(@PathVariable("userId") Long userId, @RequestBody User user) {
        User userToEdit = userService.getById(userId);
        if (user.getUsername() != null) {
            userToEdit.setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userToEdit.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        if (user.getStatus() != null) {
            userToEdit.setStatus(user.getStatus());
        }
        if (userService.update(userToEdit)) {
            return ResponseEntity.ok(userToEdit);
        } else {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
    }
    
    

}
