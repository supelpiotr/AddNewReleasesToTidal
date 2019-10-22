package pl.coderslab.app.user;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.app.exceptions.EmailNotExistException;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserRepository userRepository;

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

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
        return "redirect:signin";
    }

    @GetMapping("/signin")
    public String signIn(Model model) {
        model.addAttribute("user", new User());
        return "login/signin";
    }

    @PostMapping("/signin")
    public String login(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {
        User userDB = userRepository.findByEmail(user.getEmail())
                .orElseThrow(EmailNotExistException::new);
        boolean passwordMiss = !BCrypt.checkpw(user.getPassword(), userDB.getPassword());
        if (bindingResult.hasErrors() || passwordMiss) {
            model.addAttribute("loginFailed", passwordMiss);
            return "login/signin";
        }
        return "login/dashboard";
    }

}
