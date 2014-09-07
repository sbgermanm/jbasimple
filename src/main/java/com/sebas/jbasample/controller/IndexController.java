/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample.controller;

import com.sebas.jbasample.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Sebasy
 */

@Controller
public class IndexController  {
    
    @Autowired
    ItemsService itemsService;
    
    @RequestMapping("/index")
    public String index(Model modelo)
    {
        modelo.addAttribute("items", itemsService.findAll());
        return "index"; 
    }
}
