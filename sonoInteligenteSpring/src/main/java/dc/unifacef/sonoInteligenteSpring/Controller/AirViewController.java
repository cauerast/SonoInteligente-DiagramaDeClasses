package dc.unifacef.sonoInteligenteSpring.Controller;

import dc.unifacef.sonoInteligenteSpring.Model.AirView;
import dc.unifacef.sonoInteligenteSpring.Service.AirViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airview")
public class AirViewController {
    private final AirViewService service;

    public AirViewController(AirViewService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AirView>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirView> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AirView> create(@RequestBody AirView airView){
        AirView AV = service.create(airView);
        if(AV != null) {
            URI uri = URI.create("/airview/" + AV.getId());
            return ResponseEntity.created(uri).body(AV);
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
    public ResponseEntity<AirView> patch(@PathVariable Long id, @RequestBody AirView airView){
        AirView AV = service.patch(id, airView);
        if(AV != null){
            return ResponseEntity.ok(AV);
        }
        return ResponseEntity.notFound().build();
    }
}
