package ru.techno.testing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/create_test")
@RequiredArgsConstructor
public class CreateTestController {

    @GetMapping("/new_test")
    public String showHomePage() {
        return "view/create_test.html";
    }
}
