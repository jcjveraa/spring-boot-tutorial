package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @PostMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @PostMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName");
        name = name.toUpperCase();

        String message = "Yo! " + name;

        model.addAttribute("message", message);

        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String abc(@RequestParam("studentName") String name, Model model) {
        name = name.toUpperCase();
        String message = "Yo! " + name +" version 3 ¯\\_(ツ)_/¯";

        model.addAttribute("message", message);

        return "helloworld";
    }
}
