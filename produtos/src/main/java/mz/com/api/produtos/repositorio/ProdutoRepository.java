package mz.com.api.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mz.com.api.produtos.models.ProdutoModel;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Long>{
    
}
