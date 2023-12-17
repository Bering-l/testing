package ru.techno.testing.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.techno.testing.dto.TestDTO;
import ru.techno.testing.mapper.TestMapper;
import ru.techno.testing.repository.TestRepository;


@Slf4j
@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @Autowired
    TestRepository testRepository;
    @Autowired
    TestMapper testMapper;


    @GetMapping("/index")
    public String showHomePage(Pageable page, Model model) {
        String firstName = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("tests", testRepository.findTestByAuthorFirstName(firstName, page));
        return "test";
    }

    @GetMapping("/add")
    public String addView() {
        return "test/add";
    }

    @PostMapping("/add")
    public String add(@Valid TestDTO testDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "test/add";
        }
        testRepository.save(testMapper.toEntity(testDto));
        return "redirect:test/index";
    }
}
