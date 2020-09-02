package org.example.user;

import org.example.common.DuplicateException;
import org.example.common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User user) throws DuplicateException {
        List<User> users = userRepository.findByUserName(user.getUsername());
        if(users.isEmpty()){
            return userRepository.save(user);
        }
        throw new DuplicateException("User with user name "+user.getUsername()+" already exists");
    }

    @Override
    public User update(User user) throws DuplicateException {
        List<User> users = userRepository.findByUserName(user.getUsername());
        if(users.isEmpty()){
            return userRepository.save(user);
        }
        throw new DuplicateException("User with user name "+user.getUsername()+" already exists");
    }

    @Override
    public User get(String id) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new NotFoundException("Not resource found with id" + id);
    }

    @Override
    public boolean delete(String id) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        throw new NotFoundException("Not resource found with id" + id);
    }
}
