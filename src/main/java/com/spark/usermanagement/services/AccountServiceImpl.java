package com.spark.usermanagement.services;

import com.spark.usermanagement.dao.AppRoleRepository;
import com.spark.usermanagement.dao.AppUserRepository;
import com.spark.usermanagement.entities.AppRole;
import com.spark.usermanagement.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    AppRoleRepository appRoleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public AppUser saveUser(String username, String password, String confirmedpwd) {
       AppUser appuser=appUserRepository.findAppUserByUserName(username);
       if(appuser!=null) throw new RuntimeException("this user is already exist");
       if(!password.equals(confirmedpwd)) throw new RuntimeException("please confirm your password");
       AppUser appUser= new AppUser();
       appUser.setActivf(true);
       appUser.setUserName(username);
       appUser.setPwd(bCryptPasswordEncoder.encode(password));
       addRoleToUser(username,"USER");
       appUserRepository.save(appUser);

        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {

        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {

        return appUserRepository.findAppUserByUserName(username);
    }

    @Override
    public void addRoleToUser(String username, String role) {
          AppUser au = appUserRepository.findAppUserByUserName(username);
          AppRole ar = appRoleRepository.findAppRoleByRoleName(role);

          au.getRoles().add(ar);

    }
}
