package com.neeraj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neeraj.entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
