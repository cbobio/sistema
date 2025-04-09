package com.projeto.sistema.controllers;
import com.projeto.sistema.models.Administrador;
import com.projeto.sistema.repositorio.AdministradoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/login")
    public String index(){
        return "login/index";
    }
    @PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar){
        Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
        if(adm != null){
            return "redirect:/";
        }
        model.addAttribute("erro","Usuario ou senha Invalidos");
        return "login/index";
    }

}
