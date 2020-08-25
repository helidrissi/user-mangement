package com.spark.usermanagement.dao;


import com.spark.usermanagement.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

      public AppUser findByUserName(String username);
}
