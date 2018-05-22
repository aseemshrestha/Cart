package com.shop.service;
/*
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.shop.entities.UserEntity;
import com.shop.repository.UserRepository;
*/
/*
@Service
public class CustomUserDetailService implements UserDetailsService
{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        Optional<UserEntity> users = userRepository.findByEmail(email);
        if (!users.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(users.get());

    }

}
*/