package com.valuemanage.services;

import com.valuemanage.domain.User;

public interface UserService {
    void saveNewUser(User user);

    void saveNewUser(String username, String password, String role, Long uid);
}
