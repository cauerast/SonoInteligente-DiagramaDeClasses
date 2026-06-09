package dc.unifacef.sonoInteligenteSpring.Controller;

import dc.unifacef.sonoInteligenteSpring.Model.Paciente;
import dc.unifacef.sonoInteligenteSpring.Service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;
    public PacienteController(PacienteService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> list(){
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        if(service.remove(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Paciente> patch(@PathVariable Long id, @RequestBody Paciente paciente){
        Paciente p = service.patch(id, paciente);
        if(p != null){
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente){
        Paciente p = service.create(paciente);
        if(p != null) {
            URI uri = URI.create("/paciente/" + p.getId());
            return ResponseEntity.created(uri).body(p);
        }
        return ResponseEntity.noContent().build();
    }
}
