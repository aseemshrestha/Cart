package com.shop.models;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateUser
{

    @NotEmpty( message = "Email cannot be empty." )
    private String name;

    @NotEmpty( message = "Email cannot be empty." )
    private String email;

    @NotEmpty( message = "Password cannot be empty." )
    private String password;

    @NotEmpty( message = "Role cannot be empty." )
    private String roles;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRoles()
    {
        return roles;
    }

    public void setRoles(String role)
    {
        this.roles = role;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
