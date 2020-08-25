package com.spark.usermanagement;

import com.spark.usermanagement.dao.AppRoleRepository;
import com.spark.usermanagement.dao.AppUserRepository;
import com.spark.usermanagement.entities.AppRole;
import com.spark.usermanagement.entities.AppUser;
import com.spark.usermanagement.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }
   @Autowired
    AccountService accountService;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser u1=accountService.saveUser("hdafali","123456","123456");
        AppUser u2=accountService.saveUser("tbennana","123456","123456");

        AppRole r1=accountService.save(new AppRole(null,"ADMIN"));
        AppRole r2=accountService.save(new AppRole(null,"USER"));
    }

}
