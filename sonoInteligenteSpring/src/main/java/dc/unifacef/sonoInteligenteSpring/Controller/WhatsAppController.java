package dc.unifacef.sonoInteligenteSpring.Controller;

import dc.unifacef.sonoInteligenteSpring.Model.WhatsApp;
import dc.unifacef.sonoInteligenteSpring.Service.WhatsAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {

    private final WhatsAppService service;

    public WhatsAppController(WhatsAppService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<WhatsApp>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhatsApp> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/relatorio/{relatorioId}")
    public ResponseEntity<List<WhatsApp>> findByRelatorioId(@PathVariable Long relatorioId) {
        return ResponseEntity.ok(service.findByRelatorioId(relatorioId));
    }

    @PostMapping
    public ResponseEntity<WhatsApp> create(@RequestBody WhatsApp whatsapp) {
        WhatsApp w = service.create(whatsapp);
        if (w != null) {
            URI uri = URI.create("/whatsapp/" + w.getId());
            return ResponseEntity.created(uri).body(w);
        }
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WhatsApp> patch(@PathVariable Long id, @RequestBody WhatsApp whatsapp) {
        WhatsApp w = service.patch(id, whatsapp);
        if (w != null) {
            return ResponseEntity.ok(w);
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