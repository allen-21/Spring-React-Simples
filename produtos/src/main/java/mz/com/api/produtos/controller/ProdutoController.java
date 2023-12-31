package mz.com.api.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mz.com.api.produtos.models.ProdutoModel;
import mz.com.api.produtos.models.RespostaModelo;
import mz.com.api.produtos.servico.ProdutoServico;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoServico ps;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModel pm) {
        return ps.cadastrarAlterar(pm,"cadastrar");
    }

    @PutMapping("/alterar")
     public ResponseEntity<?> alterar(@RequestBody ProdutoModel pm) {
        return ps.cadastrarAlterar(pm,"alterar");
    }

    @GetMapping("/listar")
    public Iterable<ProdutoModel> listar() {
        return ps.listar();
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
        return ps.remover(codigo);
    }

    @GetMapping("/")
    public String rota() {
        return "API Funcionando";
    }
}
