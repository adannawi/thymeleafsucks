package com.teaproj.repository;

import org.springframework.data.repository.CrudRepository;

import com.teaproj.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
