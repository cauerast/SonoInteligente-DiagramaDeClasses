package dc.unifacef.sonoInteligenteSpring.Controller;

import dc.unifacef.sonoInteligenteSpring.Model.Relatorio;
import dc.unifacef.sonoInteligenteSpring.Service.RelatorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
    private final RelatorioService service;

    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Relatorio>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Relatorio>> findById(@PathVariable Long id){
        Optional<Relatorio> relatorio = service.findById(id);
        if(relatorio.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(relatorio);
    }

    @PostMapping
    public ResponseEntity<Relatorio> create(@RequestBody Relatorio relatorio){
        Relatorio rel = service.create(relatorio);
        if(rel != null) {
            URI uri = URI.create("/relatorio/" + rel.getId());
            return ResponseEntity.created(uri).body(rel);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        if(service.remove(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Relatorio> patch(@PathVariable Long id, @RequestBody Relatorio relatorio){
        Relatorio rel = service.patch(id, relatorio);
        if(rel != null){
            return ResponseEntity.ok(rel);
        }
        return ResponseEntity.notFound().build();
    }
}
