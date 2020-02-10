package ifma.lpweb2.Lab06.service;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class GenericService<T> {
    private final JpaRepository<T, Integer> repository;

    public GenericService(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }

    T salva(T entity){
        return repository.save(entity);
    }

    List<T> todos(){
        return repository.findAll();
    }

    T atualiza(T entity, Integer id){
        T doBanco = this.buscaPor(id);
        BeanUtils.copyProperties(entity, doBanco, "id");
        return doBanco;
    }

    T buscaPor(Integer id){
        return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public void excluirPor(Integer id) {
        this.repository.deleteById(id);
    }
}
