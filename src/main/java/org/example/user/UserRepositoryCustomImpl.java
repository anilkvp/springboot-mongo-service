package org.example.user;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @Override
    public List<User> findByUserName(String username) {
        return null;
    }
}
