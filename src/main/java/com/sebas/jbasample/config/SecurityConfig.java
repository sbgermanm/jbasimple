/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package com.sebas.jbasample.config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	DataSource dataSource;
 
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
 
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"Select name, password, 1 from Usuario where name = ?")
		.authoritiesByUsernameQuery(
			"select Usuario.name, Role.name from Usuario\n" +
"                                                              join Usuario_Role on Usuario.id = Usuario_Role.usuarios.id\n" +
"                                                              join Role on Usuario_Role.roles_id = Role.id\n" +
"                                                              where Usuario.name = ?");
	}	
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.authorizeRequests()
		.antMatchers("/users**").access("hasRole('ROLE_ADMIN')")
		.and()
		  .formLogin().loginPage("/login.html")
//                  .failureUrl("/login?error")
		  .usernameParameter("j_username").passwordParameter("j_password")
		.and()
		  .logout().logoutSuccessUrl("/logout")
//		.and()
//		  .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf().disable();
	}
}*/