package com.mpattt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.mpattt.domain.service.MyUserAuthenticationServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public Md5PasswordEncoder getMd5PasswordEncoder() {
		return new Md5PasswordEncoder();
	}

	@Autowired
	private MyUserAuthenticationServiceImpl userAuthService;

	@Autowired
	public void configureUserAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userAuthService).passwordEncoder(getMd5PasswordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/static/**", "/js/**", "/img/**","/css/**").permitAll()
				.and().authorizeRequests().antMatchers("/", "/login", "/user/signup", "/user/add", "/help", "/contact", "/about","/loginUser").permitAll()

				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").usernameParameter("email").permitAll()
				.and()
				.logout().permitAll();
	}

}