package dc.unifacef.sonoInteligenteSpring.Service;

import dc.unifacef.sonoInteligenteSpring.Model.CareOrchestrator;
import dc.unifacef.sonoInteligenteSpring.Repository.CareOrchestratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareOrchestratorService {
    private final CareOrchestratorRepository repo;

    public CareOrchestratorService(CareOrchestratorRepository repo) {
        this.repo = repo;
    }

    public List<CareOrchestrator> list() {
        return repo.findAll();
    }

    public Optional<CareOrchestrator> findById(Long id) {
        return repo.findById(id);
    }

    public CareOrchestrator create(CareOrchestrator careOrchestrator){
        return repo.save(careOrchestrator);
    }

    public CareOrchestrator patch(Long id, CareOrchestrator careOrchestrator) {
        if(repo.existsById(id)){
            careOrchestrator.setId(id);
            return repo.save(careOrchestrator);
        }
        return null;
    }

    public Boolean remove(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
