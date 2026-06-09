package dc.unifacef.sonoInteligenteSpring.Service;

import dc.unifacef.sonoInteligenteSpring.Model.WhatsApp;
import dc.unifacef.sonoInteligenteSpring.Repository.WhatsAppRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WhatsAppService {

    private final WhatsAppRepository repo;

    public WhatsAppService(WhatsAppRepository repo) {
        this.repo = repo;
    }

    public List<WhatsApp> list() {
        return repo.findAll();
    }

    public Optional<WhatsApp> findById(Long id) {
        return repo.findById(id);
    }

    public List<WhatsApp> findByRelatorioId(Long relatorioId) {
        return repo.findByRelatorioId(relatorioId);
    }

    public WhatsApp create(WhatsApp whatsapp) {
        return repo.save(whatsapp);
    }

    public WhatsApp patch(Long id, WhatsApp whatsapp) {
        if (repo.existsById(id)) {
            whatsapp.setId(id);
            return repo.save(whatsapp);
        }
        return null;
    }

    public Boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}