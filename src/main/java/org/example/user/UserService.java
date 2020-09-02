package org.example.user;

import org.example.common.DuplicateException;
import org.example.common.NotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User add(User user) throws DuplicateException;

    User update(User user) throws DuplicateException;

    User get(String id) throws NotFoundException;

    boolean delete(String id) throws NotFoundException;
}
