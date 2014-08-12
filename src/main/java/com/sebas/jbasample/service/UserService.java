/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample.service;

import com.sebas.jbasample.entity.Blog;
import com.sebas.jbasample.entity.Item;
import com.sebas.jbasample.entity.Usuario;
import com.sebas.jbasample.repository.BlogRepository;
import com.sebas.jbasample.repository.ItemRepository;
import com.sebas.jbasample.repository.UsuarioRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebasy
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findOne(int id) {
        return usuarioRepository.findOne(id);
    }

    @Transactional
    public Usuario findOneWithBlogsAndItems(int id) {
        Usuario usuario = usuarioRepository.findOne(id);
        List<Blog> blogs = blogRepository.findByUsuario(usuario);
        for (Blog blog : blogs) {
            List<Item> articulos = itemRepository.findByBlog(blog, new PageRequest(0, 10, Sort.Direction.DESC, "publishDate"));
            blog.setItems(articulos);
        }
        usuario.setBlogs(blogs);
        return usuario;
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    
    
}
