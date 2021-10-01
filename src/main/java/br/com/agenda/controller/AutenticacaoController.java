package br.com.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.model.dto.TokenDto;
import br.com.agenda.model.dto.UsuarioDto;
import br.com.agenda.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;
    
    @PostMapping
    public ResponseEntity<TokenDto> autentica(@RequestBody UsuarioDto usuarioDto){
    	Authentication authenticate = authenticationManager.
        			   authenticate(new UsernamePasswordAuthenticationToken(usuarioDto.getEmail(),usuarioDto.getSenha()));
        
        String token = tokenService.geraToken(authenticate);
        return ResponseEntity.ok(new TokenDto(token,"Bearer"));
    }

}
