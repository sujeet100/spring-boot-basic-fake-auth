package com.oauth.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@CrossOrigin
public class FooController {

    @GetMapping("/message")
    @ResponseBody
    public String getMessage(Principal principal) {
        return "Hello " + principal.getName();
    }

}
