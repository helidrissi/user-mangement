package com.spark.usermanagement.dao;


import com.spark.usermanagement.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource
@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

      public AppUser findByUsername(String username);
}
