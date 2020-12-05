package com.codehub.pf.team4.Property_Repairs.service;

import com.codehub.pf.team4.Property_Repairs.Tables.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // find user by id
    Optional<User> findUserById(Long id);

    // find user by afm
    Optional<User> findUserByAfm(Integer afm);

    // find user by email
    Optional<User> findUserByEmail(String email);

    // add user
    User addUser(User user);

    // delete user by id
    void deleteById(Long id);

}