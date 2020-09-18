package com.vignesh.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    @RequestMapping({"/vets","/vets/index"})
    public String  ListVets(){
        return "vets/index";
    }
}

