package com.dabodibo.capitalhub.controller;

import com.dabodibo.capitalhub.dto.UserAccountDto;
import com.dabodibo.capitalhub.entity.UserAccount;
import com.dabodibo.capitalhub.service.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserAccountService userAccountService;

    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    // handler method to handle user sign up request
    @GetMapping("/signup")
    public String showSignupForm(Model model){

        // this object holds from data
        UserAccountDto userAccount = new UserAccountDto();
        model.addAttribute("userAccount", userAccount);
        return "signup";
    }

    // handler method to handle user account registration form submit request
    @PostMapping("/signup/register-account")
    public String signup(@Valid @ModelAttribute("userAccount") UserAccountDto userAccount,
                         BindingResult result, Model model){
        UserAccount existingAccount = userAccountService.findByUserEmail(userAccount.getUserEmail());
        if(existingAccount != null){
            result.rejectValue("userEmail", "401", "Account with the same email already exists");
        }
        if(result.hasErrors()){
            model.addAttribute("userAccount", userAccount);
            return "home";
        }
        userAccountService.saveUserAccount(userAccount);
        return "redirect:/home"; // Registration successful page is required
    }

}
