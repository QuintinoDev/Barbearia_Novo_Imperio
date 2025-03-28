package br.com.barbershop.util.security;

import br.com.barbershop.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

//Classe para gerar token JWT
@Service
public class TokenService {

    //Parametro criado dentro de application.propertis, para esconder senha
    @Value("${api.security.token.secret}")
    private String secret;

//  Metodo para gerar token apitir da biblioteca que estamos usando
    public String gerarToken(User user) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    // Nome da API ques esta gerando o token
                    .withIssuer("API barbershop")
                    // Quem esta chamando o token
                    .withSubject(user.getLogin())
                    //Tempo que o token vai ficar disponivel, deacordo com nosso metodo
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerrar token jwt", exception);
        }

    }
// Methodo para fazer validação do token que esta sendo gerado
    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API barbershop")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

//  Tempo que nosso token vai ficar tivo apos ser gerado
    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
