package com.projeto.sistema.controllers;

import com.projeto.sistema.models.Usuarios;
import com.projeto.sistema.repositorio.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuariosController {
    @Autowired
    private UsuariosRepo repo;

    @GetMapping("/usuarios")
    public String index(Model model){
        List<Usuarios> usuarios = (List<Usuarios>) repo.findAll();
        model.addAttribute("usuarios", usuarios);

        return "usuarios/index";
    }

    @GetMapping("/usuarios/novo")
    public String novo(){
        return "usuarios/novo";
    }

    @PostMapping("/usuarios/criar")
    public String criar(Usuarios usuarios){
        repo.save(usuarios);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}")
    public String busca(@PathVariable int id, Model model){
        Optional<Usuarios> userC = repo.findById(id);
        try{
            model.addAttribute("usuarios", userC.get());
        }
        catch(Exception err){ return "redirect:/usuarios"; }

        return "/usuarios/editar";
    }

    @PostMapping("/usuarios/{id}/atualizar")
    public String atualizar(@PathVariable int id, Usuarios usuarios){
        // if(!repo.exist(id)){
        if(!repo.existsById(id)){
            return "redirect:/usuarios";
        }

        repo.save(usuarios);

        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/excluir")
    public String excluir(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/usuarios";
    }


}
