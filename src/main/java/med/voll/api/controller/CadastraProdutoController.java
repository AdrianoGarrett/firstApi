package med.voll.api.controller;

import med.voll.api.produtos.DadosCadastroProduto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastraproduto")
public class CadastraProdutoController {
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroProduto dados) {
        System.out.println(dados);
    }

}
