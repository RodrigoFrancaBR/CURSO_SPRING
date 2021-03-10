package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	private AutenticacaoService autenticacaoService;

	public SecurityConfigurations(AutenticacaoService autenticacaoService) {
		this.autenticacaoService = autenticacaoService;
	
	}
	
	// serve para configurar a parte de autenticação. A parte de controle de acesso, de login, fica nesse método.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//serve para fazer configurações de autorização. A parte de URLs, quem pode acessar cada url, perfil de acesso
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/topicos").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();
	}
	
	// serve para fazermos configurações de recursos estáticos. São requisições para arquivo CSS, Javascript, imagens, etc. 
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	
	/*
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}*/
}
