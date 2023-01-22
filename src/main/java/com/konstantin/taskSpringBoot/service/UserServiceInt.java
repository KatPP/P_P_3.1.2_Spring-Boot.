package com.konstantin.taskSpringBoot.service;

import com.konstantin.taskSpringBoot.model.User;

import java.util.List;

public interface UserServiceInt {
    public User findById(Long id);
    public List<User> findAll();
    public void saveUser(User user);
    public void deleteById(Long id);
}
