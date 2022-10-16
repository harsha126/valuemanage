package com.valuemanage.services;

import com.valuemanage.domain.User;

public interface UserService {
    public void saveNewUser(User user);
    public void saveNewUser(String username,String password,String role,Long uid);
}
