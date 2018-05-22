package com.shop.enums;

public enum Roles
{
    //SUPER_ADMIN("ROLE_SUPER_ADMIN"),
    ADMIN("ROLE_ADMIN"),
    CUSTOMER("ROLE_USER");

    private final String name;

    Roles(String name)
    {
        this.name = name;
    }

    public String value()
    {
        return name;
    }

}
