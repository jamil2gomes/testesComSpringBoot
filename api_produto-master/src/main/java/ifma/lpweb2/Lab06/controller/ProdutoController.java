package ifma.lpweb2.Lab06.controller;

import ifma.lpweb2.Lab06.controller.event.HeaderLocationEvent;
import ifma.lpweb2.Lab06.model.Produto;
import ifma.lpweb2.Lab06.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> todos(){
        return produtoService.todos();
    }

    @PostMapping
    public ResponseEntity<Produto> cria(@Validated @RequestBody Produto produto, HttpServletResponse response) {
        Produto produtoSalvo = produtoService.salva(produto);

        publisher.publishEvent(new HeaderLocationEvent(this, response, produtoSalvo.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @GetMapping("/{id}")
    public Produto buscaPor(@PathVariable Integer id) {
        return produtoService.buscaPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualiza(@PathVariable Integer id, @Validated @RequestBody Produto produto) {
        Produto produtoManager = produtoService.atualiza(id, produto);
        return ResponseEntity.ok(produtoManager);
    }
}
