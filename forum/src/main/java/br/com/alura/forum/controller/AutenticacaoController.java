package br.com.alura.forum.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.config.security.TokenService;
import br.com.alura.forum.controller.form.LoginForm;

@RestController
@RequestMapping(path = "/auth")
public class AutenticacaoController {

	private AuthenticationManager authenticationManager;
	private TokenService tokenService;

	public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService) {
		this.authenticationManager = authenticationManager;
		this.tokenService = tokenService;
		
	}

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {
		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			
			Authentication authentication = authenticationManager.authenticate(dadosLogin);
			
			String token = tokenService.gerarToken(authentication);
			
			System.out.println(token);
			
			return ResponseEntity.ok().build();
			
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().build();
		}

	}
}
