package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
public class HelloController {

    //    @GetMapping("hello") //this method handles Get requests only
//    @ResponseBody //this method does not use a template
//    public String hello() {
//        return "Hello, Spring!";
//    }
    //the path of the following level is /hello/goodbye
//    @GetMapping("goodbye") //this method handles Get requests only
//    //this method does not use a template
//    public String goodbye(@RequestParam String name) {
//        return "Goodbye, " + name + "!";
//    }

    //Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    //    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello'>" + //submit request to /hello
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }
    //lives at /form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit request to /hello
                "<p>Name: <input type='text' name='name'>" +
                "<select name='lang'>" +
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='German'>German</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "</select>" +
                "<input label='Enter Name' type='submit' value='Greet me!'>" +
                "</p>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String lang) {
        if (name == null || name.isEmpty()) {
            name = "World";
        }

        return createMessage(name, lang);
    }

    public static String createMessage(String name, String lang) {
        String greeting = "";

        if (lang.equals("English")) {
            greeting = "Hello,";
        } else if (lang.equals("French")) {
             greeting = "Bonjour,";
        } else if (lang.equals("German")) {
            greeting = "Hallo,";
        } else if (lang.equals("Spanish")) {
            greeting = "Hola,";
        }

        return "<h1>" + greeting + " " + name + "! </h1>";
    }

}
