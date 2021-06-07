package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznamPrispevku() {
        return new ModelAndView("seznam")
                .addObject("seznam", service.list());
    }

    @GetMapping("/post")
    public String redirect(String slug) {
        return String.format("redirect:/post/%s", slug);
    }

    @GetMapping("/post/{slug}")
    public ModelAndView detail(@PathVariable String slug) {
        return new ModelAndView("detail")
                .addObject("detail", service.singlePost(slug));
    }
}