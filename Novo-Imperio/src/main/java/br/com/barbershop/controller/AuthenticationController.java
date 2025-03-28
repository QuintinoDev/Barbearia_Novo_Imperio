package br.com.barbershop.controller;

import br.com.barbershop.dto.AuthenticationData;
import br.com.barbershop.dto.DadosTokenJWT;
import br.com.barbershop.model.User;
import br.com.barbershop.util.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    //Classe chamada para disparar o processo de autenticação, é o spring que faz isso
    @Autowired
    private AuthenticationManager manager;

    //Instanciando nossa classe de geração de token
    @Autowired
    private TokenService tokenService;

    //controller para fazer a autenticação
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AuthenticationData data){
        //chamando dto do propio spring para transforma meu dto em um token
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var authentication = manager.authenticate(token);
        //Passando nossa autenticação parar dentro do token para ele me devolver uma JWT
        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
