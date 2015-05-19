package by.bsuir.yarosh.controller;

import by.bsuir.yarosh.domain.*;
import by.bsuir.yarosh.sevice.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

@Controller
public class PathController {
    @Autowired
    private UserController userController;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/index", "/"}, method = {RequestMethod.GET, RequestMethod.HEAD})
    public String routeIndex(ModelMap modelMap, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth!=null && auth.isAuthenticated()) {
            if(auth.getAuthorities().iterator().next().getAuthority().equals("ROLE_ADMIN")) {
                return userController.getUsers(new HashMap<String, Object>(), modelMap);
            } else {
                return "index";
            }
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String routeRegister(ModelMap modelMap) {
        modelMap.put("user", new User());
        return "register";
    }

}
