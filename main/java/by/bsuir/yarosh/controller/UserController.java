package by.bsuir.yarosh.controller;

import by.bsuir.yarosh.domain.*;
import by.bsuir.yarosh.sevice.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.encoding.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/admin/users", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String getUsers(@RequestParam Map<String, Object> map, ModelMap modelMap) {

        if(map.get("userId")!=null && map.get("userId").toString().length()>0) {
            map.put("userId", Integer.parseInt(map.get("userId").toString()));
        }else {
            map.remove("userId");
        }

        if(map.get("rights")!=null && map.get("rights").toString().length()>0
                && Integer.parseInt(map.get("rights").toString())>=0) {
            map.put("rights", Integer.parseInt(map.get("rights").toString()));
        }else {
            map.remove("rights");
        }

        modelMap.put("users", userService.getUsers(map, 0, 0, null));
        modelMap.put("user", new User());

        for(String key: map.keySet()) {
            modelMap.put(key, map.get(key));
        }

        return "admin/users";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public String postUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult,
                           ModelMap modelMap) {
        if(!bindingResult.hasErrors()) {
            if(user.getUserId()==null) {
                userService.createUser(user);
            } else {
                userService.updateUser(user);
            }
            return getUsers(null, modelMap);
        } else {
            modelMap.put("users", userService.getUsers(null, 0, 0, null));
            return "admin/users";
        }
    }

    @RequestMapping(value = "/admin/users/{userId}.delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(value = "userId") int userId, ModelMap modelMap) {
        User user = userService.getUser(userId);

        if(user!=null) {
            userService.deactivateUser(user);
            return getUsers(null, modelMap);
        } else {
            return "admin/error";
        }
    }

    @RequestMapping(value = "/admin/users/{userId}.edit", method = RequestMethod.GET)
    public String editUser(@PathVariable(value = "userId") int userId, ModelMap modelMap) {
        User user = userService.getUser(userId);

        if (user != null) {
            modelMap.put("users", userService.getUsers(null, 0, 0, null));
            modelMap.put("user", user);
            return "admin/users";
        } else {
            return "admin/error";
        }
    }

    @RequestMapping(value = "/user/change-password", method = RequestMethod.POST)
    public String changePassword(@RequestParam String oldPass,
                                 @RequestParam String newPass,
                                 @RequestParam String repPass,
                                 ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth!=null && auth.isAuthenticated()) {
            User user = userService.getUser(auth.getName());

            if(user!=null) {
                if(user.getPassword().equals(new ShaPasswordEncoder().encodePassword(oldPass, null))) {
                    if(newPass.equals(repPass) && newPass.length() >= 4) {
                        user.setPassword(new ShaPasswordEncoder().encodePassword(newPass, null));
                        userService.updateUser(user);
                        modelMap.put("success", true);
                    } else {
                        modelMap.put("newPass_error", true);
                    }
                } else {
                    modelMap.put("oldPass_error", true);
                }

                modelMap.put("user", user);
                return "personal";
            }
        }

        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") @Valid User user,
                               BindingResult bindingResult) {
        if(!bindingResult.hasErrors()) {
            userService.createUser(user);
            return "login";
        } else {
            return "register";
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String routePersonal(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth!=null && auth.isAuthenticated()) {
            User user = userService.getUser(auth.getName());

            if(user!=null) {
                modelMap.put("user", user);
                return "personal";
            }
        }

        return "login";
    }
}
