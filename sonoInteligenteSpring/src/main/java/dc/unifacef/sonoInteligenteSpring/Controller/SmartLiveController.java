package dc.unifacef.sonoInteligenteSpring.Controller;

import dc.unifacef.sonoInteligenteSpring.Model.SmartLive;
import dc.unifacef.sonoInteligenteSpring.Service.SmartLiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/smartlive")
public class SmartLiveController {

    private final SmartLiveService service;

    public SmartLiveController(SmartLiveService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SmartLive>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmartLive> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SmartLive> create(@RequestBody SmartLive smartLive) {
        SmartLive s = service.create(smartLive);
        if (s != null) {
            URI uri = URI.create("/smartlive/" + s.getId());
            return ResponseEntity.created(uri).body(s);
        }
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SmartLive> patch(@PathVariable Long id, @RequestBody SmartLive smartLive) {
        SmartLive s = service.patch(id, smartLive);
        if (s != null) {
            return ResponseEntity.ok(s);
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