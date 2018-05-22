package com.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.shop.config.Encrypter;
import com.shop.entities.UserRole;
import com.shop.entities.User;
import com.shop.enums.Roles;
import com.shop.repository.UserRepository;
import com.shop.util.Constants;
import com.shop.util.CookieUtil;
import java.util.function.Predicate;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public Optional<User> login(String email, String password)
    {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            final String userEnteredPass = password;
            final String passfromDb = user.get().getPassword();
            final String passwordHash = Encrypter.generateHash(Encrypter.SALT.concat(userEnteredPass));
            if (user.get().getEmail().equals(email) && passfromDb.equals(passwordHash)) {
                return user;
            }
        }
        return Optional.ofNullable(null);
    }

    public List<User> findAllAdminUsers()
    {
        return userRepository.findAll();

    }

    public boolean isAdmin(Set<UserRole> roles)
    {
        // return roles.equals(Roles.ADMIN.value());
        Predicate<UserRole> role = r -> r.getName().equals(Roles.ADMIN.value());
        return roles.stream().anyMatch(role);

    }

    public boolean isUser(Set<UserRole> roles)
    {
        return roles.stream().anyMatch(role -> role.getUsers().equals(Roles.CUSTOMER.value()));

    }

    public boolean isLoggedInAdminUser(HttpSession session, HttpServletRequest request)
    {
        User user = (User)session.getAttribute(Constants.SESSION_KEY_ADMIN);
        String cookie = CookieUtil.readFromCookie(request);
        if (user == null && cookie == null) {
            return false;
        }
        return true;
    }

    public User getFromSession(HttpSession session, HttpServletRequest request)
    {
        User user = (User)session.getAttribute(Constants.SESSION_KEY_ADMIN);
        String cookie = CookieUtil.readFromCookie(request);

        if (user != null) {
            return user;
        }

        else if (!StringUtils.isEmpty(cookie)) {
            User u = new User();
            String[] cookiesData = cookie.split(CookieUtil.COOKIE_SEPARATOR);
            u.setEmail(cookiesData[0]);
            u.setName(cookiesData[1]);

            return u;
        }
        return user;
    }

    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }

    public Optional<User> findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long Id)
    {
        return userRepository.findById(Id);
    }

    public void save(User user)
    {
        userRepository.save(user);
    }
}
