package br.com.BarbeShop.Controller;

import br.com.BarbeShop.dto.CadastroBarber;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barbeiros")
public class BarberController {

    @PostMapping
    public void cadastrar(@RequestBody CadastroBarber barber){
        System.out.println(barber);
    }
}
