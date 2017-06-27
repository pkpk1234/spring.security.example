package com.example.spring.security.example.service;

import com.example.spring.security.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by pkpk1234 on 2017/6/27.
 */
@Service
public class SystemUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public SystemUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username);
    }
}
