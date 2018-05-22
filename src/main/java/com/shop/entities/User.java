package com.shop.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
// import org.springframework.security.core.GrantedAuthority;

@Entity
@Table( name = "users" )
public class User implements Serializable
{
  
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false )
    @NotEmpty
    private String name;

    @Column( nullable = false, unique = true )
    @NotEmpty( message = "Email cannot be empty." )
    private String email;

    @Column( nullable = false )
    @NotEmpty( message = "Password cannot be empty." )
    private String password;

    private String passwordResetToken;

    @Column( name = "createdOn" )
    private Date createdOn;

    @Column( name = "lastSeenOn" )
    private Date lastSeenOn;

    @Column( name = "ipAddress" )
    private String ipAddress;

    @Column( name = "active" )
    private int active;

    @ManyToMany( cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable( name = "user_role", joinColumns = @JoinColumn( name = "user_id", referencedColumnName = "id" ),
        inverseJoinColumns = @JoinColumn( name = "role_id", referencedColumnName = "id" ) )
    private Set<UserRole> roles;

    public User()
    {

    }

    public User(User users)
    {
        this.active = users.getActive();
        this.email = users.getEmail();
        this.roles = users.getRoles();
        this.name = users.getName();
        this.email = users.getEmail();
        this.id = users.getId();
        this.password = users.getPassword();
        this.passwordResetToken = users.getPasswordResetToken();
    
    }
    
    public User(Long id, String name, String email, String password, String passwordResetToken, int active,
        Set<UserRole> roles)
    {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.passwordResetToken = passwordResetToken;
        this.active = active;
        this.roles = roles;
    }

    public int getActive()
    {
        return active;
    }

    public void setActive(int active)
    {
        this.active = active;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public String getPasswordResetToken()
    {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken)
    {
        this.passwordResetToken = passwordResetToken;
    }

    public Set<UserRole> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<UserRole> roles)
    {
        this.roles = roles;
    }

    public Date getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn)
    {
        this.createdOn = createdOn;
    }

    public Date getLastSeenOn()
    {
        return lastSeenOn;
    }

    public void setLastSeenOn(Date lastSeenOn)
    {
        this.lastSeenOn = lastSeenOn;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }
}
