
package com.ejercicio1.libreria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.servlet.ModelAndView;

@Controller

public class indexController {
    
    @GetMapping
    public ModelAndView inicio(){
        return new ModelAndView("index");
    }
    
}
