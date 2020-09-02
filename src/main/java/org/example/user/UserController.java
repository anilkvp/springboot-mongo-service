package org.example.user;


import org.example.common.DuplicateException;
import org.example.common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") String id) throws NotFoundException {
        return userService.get(id);
    }

    @PostMapping
    public String create(@Valid @RequestBody User user) throws DuplicateException {
        return userService.add(user).getId();
    }

    @PutMapping
    public User update(@Valid @RequestBody User user) throws DuplicateException {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") String id) throws NotFoundException {
        return userService.delete(id);
    }

}
