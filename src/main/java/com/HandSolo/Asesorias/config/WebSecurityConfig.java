package com.HandSolo.Asesorias.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.HandSolo.Asesorias.services.UsuarioService;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.cors(Customizer.withDefaults()).
        csrf(csrf -> csrf.disable()).
        authorizeHttpRequests(auth -> auth
                .requestMatchers("/CSS/**","/login") .permitAll()/*.requestMatchers("/menu_profesional","/ProfesionalForm").hasRole("ADMIN")*/
         
                .requestMatchers("/**").authenticated()
                .and()
                .formLogin().permitAll()
                )
		
		

         return http.build();
		
    }
	
	
	@Bean
	public PasswordEncoder passwordEconder() {
		return new BCryptPasswordEncoder();
	}

}
