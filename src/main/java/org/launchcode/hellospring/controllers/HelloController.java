package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller

public class HelloController {

    //Responds to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //Responds to /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("David");
        names.add("Jake");
        names.add("Beren");
        model.addAttribute("names", names);
        return "hello-list";
    }

//    @RequestMapping(value="hello", method = RequestMethod.POST)
//    @ResponseBody
//    public String helloPost(@RequestParam String name, @RequestParam String lang) {
//        if (name == null || name.isEmpty()) {
//            name = "World";
//        }
//
//        return createMessage(name, lang);
//    }
//
//    public static String createMessage(String name, String lang) {
//        String greeting = "";
//
//        if (lang.equals("English")) {
//            greeting = "Hello,";
//        } else if (lang.equals("French")) {
//             greeting = "Bonjour,";
//        } else if (lang.equals("German")) {
//            greeting = "Hallo,";
//        } else if (lang.equals("Spanish")) {
//            greeting = "Hola,";
//        }
//
//        return "<h1>" + greeting + " " + name + "! </h1>";
//    }

}
