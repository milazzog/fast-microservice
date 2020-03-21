package ${package}.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by milazzog on 21/03/2020.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/swagger-ui.html";
    }
}
