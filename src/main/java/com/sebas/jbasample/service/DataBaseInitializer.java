/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebas.jbasample.service;

import com.sebas.jbasample.entity.Blog;
import com.sebas.jbasample.entity.Item;
import com.sebas.jbasample.entity.Role;
import com.sebas.jbasample.entity.Usuario;
import com.sebas.jbasample.repository.BlogRepository;
import com.sebas.jbasample.repository.ItemRepository;
import com.sebas.jbasample.repository.RoleRepository;
import com.sebas.jbasample.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebasy
 */
@Transactional
@Service
public class DataBaseInitializer {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void initDB() {
        Role role1 = new Role("PELOTUDO");
        roleRepository.save(role1);

        Role role2 = new Role("PUTO_AMO");
        roleRepository.save(role2);

        Role role3 = new Role("ROLE_ADMIN");
        roleRepository.save(role3);

        List<Role> misRoles = new ArrayList<Role>();
        misRoles.add(role1);
        misRoles.add(role2);
        misRoles.add(role3);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Usuario usuario = new Usuario("sebas", encoder.encode("sebas"), misRoles);
        usuario.setEnabled(true);
        usuarioRepository.save(usuario);

        List<Role> misRoles2 = new ArrayList<Role>();
        misRoles2.add(role1);
        misRoles2.add(role2);
        misRoles2.add(role3);
        Usuario usuario2 = new Usuario("admin", encoder.encode("admin"), misRoles2);
        usuario2.setEnabled(true);
        usuarioRepository.save(usuario2);

        Blog blog = new Blog("JavavidBlog", "http://feeds.feedburner.com/javavids?format=xml", usuario);
        blogRepository.save(blog);

        Item item1 = new Item("PrimerArticulo", new Date(), blog, "www.javavids.com");
        itemRepository.save(item1);

        Item item2 = new Item("SegundoArticulo", new Date(), blog, "www.javavids.com");
        itemRepository.save(item2);

        int cont = 3;
        Item itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

        itemTemp = new Item("Articulo" + cont++, new Date(), blog, "www.javavids.com");
        itemRepository.save(itemTemp);

    }
}
