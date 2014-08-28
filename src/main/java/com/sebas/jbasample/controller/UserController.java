/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebas.jbasample.controller;

import com.sebas.jbasample.entity.Blog;
import com.sebas.jbasample.entity.Usuario;
import com.sebas.jbasample.service.BlogService;
import com.sebas.jbasample.service.UserService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sebasy
 */
@Controller
public class UserController {

    @ModelAttribute("bindUserObject")
    public Usuario constructUsuario(){
        return new Usuario();
    }
    
    @ModelAttribute("blogBindObject")
    public Blog constructBlog(){
        return new Blog();
    }
    
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BlogService blogService;


    @RequestMapping("/account")
    public String account(Model modelo, Principal principal) {
        String name = principal.getName();
        modelo.addAttribute("usuario", userService.findOneWithBlogsAndItems(name));
        return "cuentaUsuarioTilesDefinition";
    }

    @RequestMapping(value="/account", method = RequestMethod.POST)
    public String saveBlog(Model model,@Valid @ModelAttribute("blogBindObject") Blog blog, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()){
            return account(model, principal);
        }
        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account.html";
    }

    @RequestMapping("/blog/remove/{id}")
    public String borrarBlog(@PathVariable int id) {
        Blog blog = blogService.findOne(id);
        blogService.delete(blog);
        return "redirect:/account.html";
    }
    

}
