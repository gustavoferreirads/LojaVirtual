package br.com.lojavirtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: JoãoGustavo
 * Date: 06/11/14
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {


    @RequestMapping("/home")
    public String execute() {
        return "portal/index";
    }
}
