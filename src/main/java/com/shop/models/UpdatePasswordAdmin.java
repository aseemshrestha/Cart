package com.shop.models;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdatePasswordAdmin
{

    private Long id;

    @NotEmpty( message = "Old Password cannot be empty." )
    private String oldPassword;
    @NotEmpty( message = "Password cannot be empty." )
    private String newPassword;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getOldPassword()
    {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword()
    {
        return newPassword;
    }

    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }

}
