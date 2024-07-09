package com.SBproject.Main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SBproject.Main.model.User;
@Repository
public interface UserRepository extends JpaRepository<User , Long> {

}
