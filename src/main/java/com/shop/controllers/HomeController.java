package com.shop.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shop.entities.User;
import com.shop.entities.UserRole;
import com.shop.service.UserService;
import com.shop.util.Constants;
import com.shop.util.CookieUtil;

@Controller
public class HomeController
{
    @Autowired
    private UserService userService;

    private static final Logger LOG = LogManager.getLogger(HomeController.class);

    @GetMapping( "/" )
    public String home()
    {
        return "cart.index";
    }

    @GetMapping( "/signup" )
    public String login(Model model)
    {
        com.shop.models.User user = new com.shop.models.User();
        model.addAttribute("userForm", user);
        return "cart.login";
    }

    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public String loginPOST(@Valid @ModelAttribute( "userForm" ) com.shop.models.User userForm, BindingResult result,
        Model model,
        HttpSession session, HttpServletResponse response)
    {
        if (result.hasErrors()) {
            return "cart.login";
        }

        Optional<User> user = userService.login(userForm.getEmail(), userForm.getPassword());

        if (!user.isPresent()) {
            model.addAttribute("invalidUser", "Email or Password is invalid.");
            return "cart.login";
        }

        Set<UserRole> roles = user.get().getRoles();

        user.get().setLastSeenOn(new Date());
        try {
            userService.save(user.get());
        } catch (Exception ex) {
            LOG.debug("[HomeController][Login] Error updating lastSeenOn field" + ex);
        }
        if (userService.isAdmin(roles)) {
            session.setAttribute(Constants.SESSION_KEY_ADMIN, user.get());
            CookieUtil.writeToCookie(response, user.get());
            return "redirect:/secure/home";

        }
        return "cart.index";
    }

    @RequestMapping( value = "/logout", method = RequestMethod.GET )
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
        throws IOException
    {
        CookieUtil.clearCookies(response);
        session.removeAttribute(Constants.SESSION_KEY_ADMIN);
        session.invalidate();
        return "redirect:/";

    }
}
