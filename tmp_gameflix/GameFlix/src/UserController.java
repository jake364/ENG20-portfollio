


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String email, Model model) {
        User user = service.registerUser(username, password, email);
        if (user == null) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
        model.addAttribute("message", "Registration successful! Please login.");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = service.loginUser(username, password);
        if (user == null) {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
        model.addAttribute("username", user.getUsername());
        return "home";
    }
}

