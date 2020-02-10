package ifma.lpweb2.Lab06.repository;

import ifma.lpweb2.Lab06.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findByNome(String nome);
}
