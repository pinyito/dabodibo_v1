package com.dabodibo.capitalhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {

    @GetMapping({"/", "index"})
    public String websiteLandingPage(Model model) {
        model.addAttribute("nothing", null);
        return "index";
    }
}
