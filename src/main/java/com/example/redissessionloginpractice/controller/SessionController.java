package com.example.redissessionloginpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {


    @GetMapping("/")
    public String home(Model model, HttpSession httpSession){

        String preferredLang = (String) httpSession.getAttribute("preferredLang");

        model.addAttribute("preferredLang", preferredLang);
        model.addAttribute("sessionId", httpSession.getId());

        return "index";
    }

    @GetMapping("/setLang")
    public String setLang(@RequestParam("preferredLang") String preferredLang, HttpSession httpSession){
        httpSession.setAttribute("preferredLang", preferredLang);
        return "redirect:/";
    }

    @PostMapping("/destroy")
    public String destroySession(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }



}
