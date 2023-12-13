package mz.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mz.com.api.produtos.models.ProdutoModel;
import mz.com.api.produtos.models.RespostaModelo;
import mz.com.api.produtos.repositorio.ProdutoRepository;

@Service
public class ProdutoServico {

   @Autowired
   private ProdutoRepository pr;

   @Autowired
   private RespostaModelo rm;

   // Metodo para listar
   public Iterable<ProdutoModel> listar() {
      return pr.findAll();
   }

   // Metodo para cadastrar ou alterr
   public ResponseEntity<?> cadastrarAlterar(ProdutoModel pm, String acao) {
      if (pm.getNome().equals("")) {
         rm.setMensagem("O nome do produto é obrigatorio");
         return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);

      } else if (pm.getMarca().equals("")) {
         rm.setMensagem("o nome da marca é obrigatorio");
         return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
      } else {
         if (acao.equals("cadastrar")) {
            return new ResponseEntity<ProdutoModel>(pr.save(pm), HttpStatus.CREATED);
         } else {
            return new ResponseEntity<ProdutoModel>(pr.save(pm), HttpStatus.OK);
         }
      }
   }

   //Metodo para remover
   public ResponseEntity<RespostaModelo> remover(long codigo){
      pr.deleteById(codigo);

      rm.setMensagem("Produto removido com sucesso");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
   }
}
