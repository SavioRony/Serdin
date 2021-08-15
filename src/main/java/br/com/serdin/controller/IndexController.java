package br.com.serdin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    /**
     * Metodo para abri a tela de principal
     * @return String - tela de home
     */
    @RequestMapping("/")
    public ModelAndView login() {
        return new ModelAndView("index");
    }
}
