package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import web.models.User;
import web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
        return "allusers";
    }
    @GetMapping(value="/delete")
    public String deleteUser(@RequestParam Map<String, String> params, ModelMap model) {
        try {
            userService.removeUser(Long.parseLong(params.get("id")));
            model.addAttribute("message", "User by ID " + params.get("id") + " deleted.");
        } catch (NumberFormatException e) {
            model.addAttribute("message", "Illegal format of ID");
        } catch (Exception e) {
            model.addAttribute("message", "ERROR. User was not deleted");
            e.printStackTrace();
        }
        return "userdeleted";
    }
    @GetMapping(value = "/add")
    public String saveUser(@RequestParam Map<String, String> params, ModelMap model) {
        String name = params.get("name");
        String lastName = params.get("lastname");
        String email = params.get("email");
        int phoneNumber = -1;
        try {
            phoneNumber = Integer.parseInt(params.get("phone"));
        } catch (NumberFormatException e) {}
        userService.addUser(new User(name, lastName, phoneNumber, email));
        return allUsersList(model);
    }
    @GetMapping(value = "/redact")
    public String redactionForm(@RequestParam Map<String, String> params, ModelMap model) {
        long id = -1;
        try {
            id = Long.parseLong(params.get("id"));
        } catch (NumberFormatException e) {}
        if (id != -1) {
            model.addAttribute("user", userService.getUser(id));
        }
        return "redactuser";
    }
    @GetMapping(value = "/do_redaction")
    public String doRedact(@RequestParam Map<String, String> params, ModelMap model) {
        String name = params.get("name");
        String lastName = params.get("lastname");
        String email = params.get("email");
        long id = -1;
        int phoneNumber = -1;
        try {
            id = Long.parseLong(params.get("id"));
            phoneNumber = Integer.parseInt(params.get("phone"));
        } catch (NumberFormatException e) {}
        try {
            model.addAttribute("redactionmessage", "Success. " +
                    userService.redactUser(id, new User(name, lastName, phoneNumber, email)));
        } catch (Exception e) {
            model.addAttribute("redactionmessage", "Error while redacting");
            e.printStackTrace();
        }
        return "redactingresult";
    }
}
