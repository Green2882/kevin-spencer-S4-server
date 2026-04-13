package com.keyin.user;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRestRepository userRepository;

    public UserService(UserRestRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.keyin.user.User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}