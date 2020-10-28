package com.video.social.controller;

import com.video.social.dataaccess.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class HomeController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/")
    public String home(final Model model) {
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(videoRepository.findAll(), 1);
        model.addAttribute("videos", reactiveDataDrivenMode);
        return "home";
    }
}
