package com.poornima.placement.repository;


import com.poornima.placement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
