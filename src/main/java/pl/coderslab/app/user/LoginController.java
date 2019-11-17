package pl.coderslab.app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.app.tidal.TidalServiceImplementation;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;
    private final TidalServiceImplementation tidalServiceImplementation;

    @GetMapping("/home")
    public String homepage() {
        return "../../index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "login/register";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login/register";
        }

        userService.saveUser(user);
        return "redirect:signin";
    }

    @GetMapping("/signin")
    public String signIn(Model model) {
        model.addAttribute("user", new User());
        return "login/signin";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();
        tidalServiceImplementation.login(username,tidalPassword);
        model.addAttribute("user", new User());
        return "dashboard/dashboard";
    }

}
