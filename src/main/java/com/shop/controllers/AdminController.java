package com.shop.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.config.Encrypter;
import com.shop.entities.Category;
import com.shop.entities.Product;
import com.shop.entities.User;
import com.shop.entities.UserRole;
import com.shop.enums.Roles;
import com.shop.service.ProductService;
import com.shop.service.UserService;
import com.shop.util.Categories;
import com.shop.util.ClientInfo;
import com.shop.util.Status;

@Controller
public class AdminController
{

    @Autowired
    private UserService userService;

    private static final Logger LOG = LogManager.getLogger(AdminController.class);

    @GetMapping( "/secure/home" )
    public String home(HttpSession session, HttpServletRequest request, Model model)
    {
        User user = userService.getFromSession(session, request);
        if (user != null) {
            model.addAttribute("timenow", new java.util.Date());
            model.addAttribute("name", user.getName());
            model.addAttribute("id", user.getId());
            return "cart_secure.home";
        }
        return "redirect:/";
    }

    @GetMapping( "/secure/users" )
    public String users(HttpSession session, HttpServletRequest request, Model model)
    {
        User user = userService.getFromSession(session, request);
        if (user != null) {
            model.addAttribute("timenow", new java.util.Date());
            model.addAttribute("name", user.getName());
            model.addAttribute("userList", userService.findAllAdminUsers());
            return "cart_secure.manage_users";
        }
        return "redirect:/";
    }

    @GetMapping( "/secure/addNewUser" )
    public String addNewUser(HttpSession session, HttpServletRequest request, Model model)
    {
        com.shop.models.CreateUser createUser = new com.shop.models.CreateUser();
        Map<String, String> roles = new HashMap<>();
        roles.put(Roles.CUSTOMER.value(), Roles.CUSTOMER.value());
        roles.put(Roles.ADMIN.value(), Roles.ADMIN.value());
        model.addAttribute("rolesList", roles);
        model.addAttribute("createUserForm", createUser);
        return "cart_secure.addNew";
    }

    @RequestMapping( value = "/secure/createNewUser", method = RequestMethod.POST )
    public String createNewUser(@Valid @ModelAttribute( "createUserForm" ) com.shop.models.CreateUser createUserForm,
        BindingResult result,
        Model model, HttpSession session, HttpServletRequest request)
    {

        if (result.hasErrors()) {
            return "cart_secure.addNew";
        }
        Optional<User> _user = userService.findByEmail(createUserForm.getEmail());
        if (_user.isPresent()) {
            model.addAttribute("msg", "Email Already exists.");
            return "cart_secure.addNew";
        }
        Set<UserRole> roleList = new HashSet<>();
        UserRole role = new UserRole();
        role.setName(createUserForm.getRoles());
        roleList.add(role);
        User user = new User();
        user.setName(createUserForm.getName());
        user.setEmail(createUserForm.getEmail());
        user.setPassword(Encrypter.generateHash(Encrypter.SALT.concat(createUserForm.getPassword())));
        user.setActive(1);
        user.setRoles(roleList);
        user.setCreatedOn(new Date());
        user.setLastSeenOn(new Date());
        user.setIpAddress(ClientInfo.getClientIp(request));
        try {

            userService.save(user);
            model.addAttribute("userId", user.getId());
            model.addAttribute("msg", "User msg Successfully.");
        } catch (Exception ex) {
            LOG.debug("[AdminController][CreateUser] Error creating new user from admin:", ex);
        }
        return "cart_secure.addNew";
    }

    @RequestMapping( value = "/secure/deleteuser/{id}", method = RequestMethod.GET )
    public String deleteUser(@PathVariable( "id" ) Long id, Model model, HttpSession session,
        HttpServletRequest request)
    {
        try {
            userService.deleteUser(id);
        } catch (Exception ex) {
            LOG.debug("[AdminController][delete user] Error deleting user  with id:", id);
        }
        model.addAttribute("msg", "User Deleted Successfully.");
        return "redirect:/secure/users";
    }

    @GetMapping( "/secure/updatepass" )
    public String updatePass(Model model, HttpSession session,
        HttpServletRequest request)
    {
        com.shop.models.UpdatePasswordAdmin userPass = new com.shop.models.UpdatePasswordAdmin();
        model.addAttribute("updatePassForm", userPass);
        return "cart_update_pass_admin";
    }

    @RequestMapping( value = "/secure/updatepassnow", method = RequestMethod.POST )
    public String updatePassPOST(
        @Valid @ModelAttribute( "updatePassForm" ) com.shop.models.UpdatePasswordAdmin updatePassForm,
        Model model,
        HttpSession session,
        HttpServletRequest request,
        BindingResult result)
    {
        if (result.hasErrors()) {
            return "cart_update_pass_admin";
        }
        User user = userService.getFromSession(session, request);
        final String pass = Encrypter.generateHash(Encrypter.SALT.concat(updatePassForm.getOldPassword()));
        if (user.getPassword().equals(pass)) {
            try {
                user.setPassword(Encrypter.generateHash(Encrypter.SALT.concat(updatePassForm.getNewPassword())));
                userService.save(user);
                model.addAttribute("updated", "Password successfully updated");
            } catch (Exception ex) {
                LOG.debug("[Admin Controller][updatePassPOST]Error updating password", ex);
            }
        } else {
            model.addAttribute("updated", "Existing Password didn't match");
        }
        return "cart_update_pass_admin";
    }

}
