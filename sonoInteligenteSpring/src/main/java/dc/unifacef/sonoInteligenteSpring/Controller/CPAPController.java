package dc.unifacef.sonoInteligenteSpring.Controller;

import dc.unifacef.sonoInteligenteSpring.Model.CPAP;
import dc.unifacef.sonoInteligenteSpring.Service.CPAPService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cpap")
public class CPAPController {

    private final CPAPService service;

    public CPAPController(CPAPService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CPAP>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CPAP> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<CPAP>> findByPacienteId(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(service.findByPacienteId(pacienteId));
    }

    @PostMapping
    public ResponseEntity<CPAP> create(@RequestBody CPAP cpap) {
        CPAP c = service.create(cpap);
        if (c != null) {
            URI uri = URI.create("/cpap/" + c.getId());
            return ResponseEntity.created(uri).body(c);
        }
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CPAP> patch(@PathVariable Long id, @RequestBody CPAP cpap) {
        CPAP c = service.patch(id, cpap);
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