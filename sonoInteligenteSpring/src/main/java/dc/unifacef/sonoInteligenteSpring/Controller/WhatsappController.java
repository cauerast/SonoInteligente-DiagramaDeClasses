package dc.unifacef.sonoInteligenteSpring.Controller;

import dc.unifacef.sonoInteligenteSpring.Model.WhatsApp;
import dc.unifacef.sonoInteligenteSpring.Service.WhatsappService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/whatsapp")
public class WhatsappController {
        private final WhatsappService service;
        public WhatsappController(WhatsappService service){

            this.service = service;
        }
        @GetMapping
        public ResponseEntity<List<WhatsApp>> listar(){
            return ResponseEntity.ok(service.listar());
        }
        @GetMapping("/{id}")
        public ResponseEntity<Optional<Whatsapp>> buscarPorId(@PathVariable Long id){
            Optional<Whatsapp> whats = service.buscarPorId(id);
            if (whats.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(whats);
        }
        @PostMapping
        public ResponseEntity<WhatsApp> salva(@RequestBody Whatsapp whatsapp){
            WhatsApp novo = service.salva(produto);
            if (novo != null) {
                URI uri = URI.create("/whatsapp/" + novo.getId());
                return ResponseEntity.created(uri).body(novo);
            }
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> remove(@PathVariable Long id){
            if (service.remove(id)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        }

        @PatchMapping("/{id}")
        public ResponseEntity<Whatsapp> atualiza(@PathVariable Long id,
                                                @RequestBody WhatsApp alterado){
            Whatsapp repost = service.atualiza(id, alterado);
            if (repost != null){
                return ResponseEntity.ok(repost);
            }
            return ResponseEntity.notFound().build();
        }
}

