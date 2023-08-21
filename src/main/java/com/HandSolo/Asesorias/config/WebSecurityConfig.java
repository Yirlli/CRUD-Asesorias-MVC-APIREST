package com.HandSolo.Asesorias.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.HandSolo.Asesorias.implementacion.ISecurityUserDetails;
import com.HandSolo.Asesorias.services.UsuarioService;
import com.HandSolo.Asesorias.utils.RolNombre;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
		
		@Autowired
		UsuarioService usuarioService;
		
		@Autowired
		ISecurityUserDetails iSecurity;
		
		@Bean
		public DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
			authProvider.setUserDetailsService(iSecurity);
			authProvider.setPasswordEncoder(passwordEnconder()) ;
			return authProvider;
		}
		
		@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
			http.cors(Customizer.withDefaults()).
	        csrf(csrf -> csrf.disable()).
	        authorizeHttpRequests(auth -> auth
	                .requestMatchers("/",
	                		"/Index", 
	                		"/Login",
	                		"/CSS/**",
	                		"/api/lista",
	                		 "/JS/**").permitAll()
	                .requestMatchers("/menu_admin",
	                		"/CrearAdministrativo", "/ListaAdministrativo", "/ListaAdministrativo/editar/{id}", "/ListaAdministrativo/{id}",
	                		"/ProfesionalForm", "/ListaProfesional", "/ListaProfesional/editar/{id}","/ListaProfesional/{id}", 
	                		"/ClienteForm","/ListarCliente", "/ListarCliente/editar/{id}", "/ListarCliente/{id}"
	                		).hasAuthority("ADMINISTRADOR")
	                .requestMatchers("/menu_profesional").hasAuthority("PROFESIONAL")
	                .requestMatchers("/menu_cliente",
	                		"/Contacto", "/CrearContacto", "/ContactoEnviado","/menu_capacitacion",
	                		"/CrearCapacitacion", "/ListaCapacitacion", "ListaCapacitacion/editar/{id}","/ListaCapacitacion/{id}", "/ListaCapacitacion/{id}" ).hasAuthority("CLIENTE")
	                .anyRequest().authenticated()
	                
	                
	                )
	        		
	        		.userDetailsService(iSecurity)
	        		.formLogin(formLogin ->
	        			formLogin
	        			.loginPage("/Login")
	        			.successHandler(succesHandler())
	        			.permitAll()
	        			
	        			)
	        
	        		.logout(logout ->
	                logout
	                    .invalidateHttpSession(true)
	                    .clearAuthentication(true)
	                    .logoutUrl("/logout")
	                    .logoutSuccessUrl("/Login?logout")
	                    .permitAll()
	        				);

	
	         return http.build();
			
	    }
		
		
		@Bean
		public BCryptPasswordEncoder passwordEnconder() {
			return new BCryptPasswordEncoder();
		}
		
		@Configuration
	    public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

		    @Autowired
		    private WebSecurityConfig webSecurityConfig;
	
		    @Override
		    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		        auth.authenticationProvider(webSecurityConfig.authenticationProvider());
		    }
	    }
		
		public AuthenticationSuccessHandler succesHandler() {
			return((request, response, authentication) ->{
				response.sendRedirect("/");
			});
		}
	
	}