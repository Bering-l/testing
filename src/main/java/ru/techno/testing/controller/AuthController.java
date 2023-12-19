package ru.techno.testing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.techno.testing.dto.CandidateDTO;

@Slf4j
@Controller
@SessionAttributes("candidate")
public class AuthController {

    @GetMapping("/registration")
    public String showRegistrationForm(@ModelAttribute CandidateDTO candidate) {
        return "registration/registration";
    }

    @PostMapping("/registration")
    public String processRegistrationForm(@ModelAttribute("candidate") CandidateDTO candidate, BindingResult result) {
        if (result.hasErrors()) {
            return "registration/registration";
        }
        return "redirect:/login";
    }
}
