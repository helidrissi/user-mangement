package com.spark.usermanagement.dao;


import com.spark.usermanagement.entities.AppRole;
import com.spark.usermanagement.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

      public AppRole findAppRoleByRoleName(String roleName);
}
