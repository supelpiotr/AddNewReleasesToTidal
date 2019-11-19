package pl.coderslab.app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.app.tidal.TidalPlaylist;
import pl.coderslab.app.tidal.TidalServiceImplementation;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final UserServiceImpl userService;
    private final TidalServiceImplementation tidalServiceImplementation;

    @GetMapping("/dashboard")
    public String dashboard(Model model, @AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();
        tidalServiceImplementation.login(username,tidalPassword);
        model.addAttribute("user", new User());
        return "dashboard/dashboard";
    }

    @ModelAttribute("userPlaylists")
    public List<TidalPlaylist> findAllPlaylists(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        String tidalPassword = userService.findByUserName(username).getTidalPassword();
        tidalServiceImplementation.login(username,tidalPassword);
        return tidalServiceImplementation.getUserPlaylists();
    }

}
