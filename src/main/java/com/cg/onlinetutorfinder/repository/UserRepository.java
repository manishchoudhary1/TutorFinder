package com.cg.onlinetutorfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinetutorfinder.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

  User findByUserEmail(String userEmail);
  List<User> findByUserType(String userType);

}
