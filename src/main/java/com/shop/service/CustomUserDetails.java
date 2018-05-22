package com.shop.service;
/*
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shop.entities.UserEntity;

public class CustomUserDetails extends UserEntity implements UserDetails
{

    public CustomUserDetails(final UserEntity users)
    {
        super(users);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return getRoles()
            .stream()
            .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName()))
            .collect(Collectors.toList());

    }

    @Override
    public String getPassword()
    {
        return super.getPassword();
    }

    @Override
    public String getUsername()
    {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return super.getActive() == 1 ? true : false;
    }

}
*/
