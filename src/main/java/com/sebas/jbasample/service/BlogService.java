/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebas.jbasample.service;

import com.sebas.jbasample.entity.Blog;
import com.sebas.jbasample.entity.Usuario;
import com.sebas.jbasample.repository.BlogRepository;
import com.sebas.jbasample.repository.UsuarioRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Sebasy
 */
@Service
@Transactional
public class BlogService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    

    @Autowired
    private BlogRepository blogRepository;

    public void save(Blog blog, String name) {
        Usuario usuario = usuarioRepository.findByName(name);
        blog.setName(name);
        blogRepository.save(blog);
    
    }

    
}
 