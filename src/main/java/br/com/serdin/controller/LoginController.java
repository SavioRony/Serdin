package br.com.serdin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /**
     * Metodo para abri a tela de login
     * @return String - tela de login
     */
    @GetMapping({"/login"})
    public String login() {
        return "login";
    }


}
