package dc.unifacef.sonoInteligenteSpring.Controller;

import dc.unifacef.sonoInteligenteSpring.Model.CareOrchestrator;
import dc.unifacef.sonoInteligenteSpring.Service.CareOrchestratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/careorchestrator")
public class CareOrchestratorController {

    private final CareOrchestratorService service;

    public CareOrchestratorController(CareOrchestratorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CareOrchestrator>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CareOrchestrator> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CareOrchestrator> create(@RequestBody CareOrchestrator careOrchestrator) {
        CareOrchestrator c = service.create(careOrchestrator);
        if (c != null) {
            URI uri = URI.create("/careorchestrator/" + c.getId());
            return ResponseEntity.created(uri).body(c);
        }
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CareOrchestrator> patch(@PathVariable Long id, @RequestBody CareOrchestrator careOrchestrator) {
        CareOrchestrator c = service.patch(id, careOrchestrator);
        if (c != null) {
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        if (service.remove(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}