package com.dabodibo.capitalhub.controller;

import com.dabodibo.capitalhub.dto.UserAccountDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowWebsiteController {

    @GetMapping({"/", "home"})
    public String showWebsite(Model model) {
        UserAccountDto userAccount = new UserAccountDto();
        model.addAttribute("userAccount", userAccount);
        return "index";
    }
}
