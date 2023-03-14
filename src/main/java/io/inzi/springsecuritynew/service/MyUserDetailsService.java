package io.inzi.springsecuritynew.service;

import io.inzi.springsecuritynew.UserRepository;
import io.inzi.springsecuritynew.model.MyUser;
import io.inzi.springsecuritynew.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Username does not exist"));
        return user.map(MyUser::new).get();
    }

}
