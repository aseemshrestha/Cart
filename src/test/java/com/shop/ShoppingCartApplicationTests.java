package com.shop;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.config.Encrypter;
import com.shop.entities.User;
import com.shop.entities.UserRole;
import com.shop.enums.Roles;
import com.shop.repository.CategoryRepository;
import com.shop.repository.ProductRepository;
import com.shop.repository.UserRepository;
import com.shop.util.Categories;
import com.shop.util.ClientInfo;

@RunWith( SpringRunner.class )
@SpringBootTest
public class ShoppingCartApplicationTests
{

    @Autowired
    private DataSource ds;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CategoryRepository productRepo;
    @Autowired
    private HttpServletRequest request;

    @Test
    public void testConnection() throws SQLException
    {
        String schema = ds.getConnection().getCatalog();
        assertEquals("cart", schema);
    }

    @Test
    public void seedData()
    {
        UserRole role = new UserRole();
        User user = new User();
        Set<UserRole> roleList = new HashSet<>();
        List<User> userList = new ArrayList<>();
        user.setName("Admin Doe");
        user.setEmail("admin@admin.com");
        user.setPassword(Encrypter.generateHash(Encrypter.SALT.concat("hello")));
        user.setPasswordResetToken("hello");
        user.setActive(1);
        user.setCreatedOn(new Date());
        user.setLastSeenOn(new Date());
        user.setIpAddress(ClientInfo.getClientIp(this.request));
        role.setName(Roles.ADMIN.value());
        roleList.add(role);
        user.setRoles(roleList);
        role.setUsers(userList);
        roleList.add(role);
        userList.add(user);
        //   userList1.add(user1);
        // roleRepo.save(role);

        for (User u : userList)
            userRepo.save(u);
    }

}
