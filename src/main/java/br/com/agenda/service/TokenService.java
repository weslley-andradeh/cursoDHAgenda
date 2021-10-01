package br.com.agenda.service;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.agenda.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	private  String  secret = "ab12";
    private  long expiration = 1000000;
    
    public String geraToken(Authentication authentication){
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date exp = new Date(hoje.getTime() + expiration) ;

        return Jwts.builder().
               setSubject(usuarioLogado.getId().toString()).
               setIssuedAt(hoje).
               setExpiration(exp).
               signWith(SignatureAlgorithm.HS512,secret).
               compact();
    }

}
