package org.example.user;

import java.util.List;


public interface UserRepositoryCustom {
    List<User> findByUserName(String username);
}
