package com.example.demo.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;



@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    private String secret = "secret";
    private int expiration = 36000;

    public String generateToken(Authentication authentication){
    	logger.info(">>> generateToken" );
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error(">>> validateToken >>> token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error(">>> validateToken >>> token no soportado");
        }catch (ExpiredJwtException e){
            logger.error(">>> validateToken >>> token expirado");
        }catch (IllegalArgumentException e){
            logger.error(">>> validateToken >>> token vacío");
        }catch (SignatureException e){
            logger.error(">>> validateToken >>> fail en la firma");
        }
        return false;
    }
}
