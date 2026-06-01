package dc.unifacef.sonoInteligenteSpring.Controller;

import dc.unifacef.sonoInteligenteSpring.Model.Administrador;
import dc.unifacef.sonoInteligenteSpring.Model.Paciente;
import dc.unifacef.sonoInteligenteSpring.Service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AdministradorController {

    private final AdministradorService service;

    public AdministradorController(AdministradorService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> data) {
        String email = data.get("email");
        String senha = data.get("senha");

        try {
            String mensagem = service.efetuarLogin(email, senha);
            return ResponseEntity.ok(mensagem);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Administrador> patch(@PathVariable Long id, @RequestBody Administrador admin){
        Administrador adm = service.patch(id, admin);
        if(adm != null){
            return ResponseEntity.ok(adm);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Administrador> create(@RequestBody Administrador admin){
        Administrador adm = service.create(admin);
        if(adm != null) {
            URI uri = URI.create("/admin/" + adm.getId());
            return ResponseEntity.created(uri).body(adm);
        }
        return ResponseEntity.noContent().build();
    }

}
