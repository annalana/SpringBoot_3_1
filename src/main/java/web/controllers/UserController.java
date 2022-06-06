package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import web.models.User;
import web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/")
    public String allUsersList(ModelMap model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("users", userList);
        model.addAttribute("newuser", new User());
        return "allusers";
    }
    @GetMapping(value="/delete")
    public String deleteUser(@RequestParam(value="id") long id, ModelMap model) {
        try {
            userService.removeUser(id);
            model.addAttribute("message", "User by ID " + id + " deleted.");
        } catch (Exception e) {
            model.addAttribute("message", "ERROR. User was not deleted");
            e.printStackTrace();
        }
        return "userdeleted";
    }
    @GetMapping(value = "/add")
    public String saveUser(@ModelAttribute User user, ModelMap model) {
        userService.addUser(new User(user));
        return allUsersList(model);
    }
    @GetMapping(value = "/redact")
    public String redactionForm(@RequestParam(value="id") long id, ModelMap model) {
        if (id != -1) {
            model.addAttribute("user", userService.getUser(id));
        }
        return "redactuser";
    }
    @GetMapping(value = "/do_redaction")
    public String doRedact(@ModelAttribute User user, ModelMap model) {
        try {
            model.addAttribute("redactionmessage", "Success. " +
                    userService.redactUser(user.getId(), user));
        } catch (Exception e) {
            model.addAttribute("redactionmessage", "Error while redacting");
            e.printStackTrace();
        }
        return "redactingresult";
    }
}
