package com.spark.usermanagement.services;

import com.spark.usermanagement.entities.AppRole;
import com.spark.usermanagement.entities.AppUser;

public interface AccountService {

   AppUser saveUser(String username,String password,String confirmedpwd);
   AppRole save(AppRole role);
   AppUser loadUserByUsername(String username);
   void addRoleToUser(String username,String role);

}
