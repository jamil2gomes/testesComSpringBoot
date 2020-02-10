package ifma.lpweb2.Lab06.service;

import ifma.lpweb2.Lab06.model.Produto;
import ifma.lpweb2.Lab06.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository albumRepository;

    private final GenericService<Produto> genericService;

    @Autowired
    public ProdutoService(ProdutoRepository albumRepository) {
        this.albumRepository = albumRepository;
        genericService = new GenericService<>(albumRepository);
    }

    @Transactional(readOnly = true)
    public Optional<Produto> buscaPor(String nome){
        return Optional.ofNullable(albumRepository.findByNome(nome));
    }

    @Transactional
    public Produto salva(Produto entity) {
        return genericService.salva(entity);
    }

    @Transactional(readOnly = true)
    public List<Produto> todos() {
        return genericService.todos();
    }

    @Transactional
    public Produto atualiza(Integer id, Produto entity) {
        return genericService.atualiza(entity, id);
    }

    @Transactional(readOnly = true)
    public Produto buscaPor(Integer id) {
        return genericService.buscaPor(id);
    }

    @Transactional
    public void excluirPor(Integer id) {
        genericService.excluirPor(id);
    }
}
