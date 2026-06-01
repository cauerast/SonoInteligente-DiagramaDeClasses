package dc.unifacef.sonoInteligenteSpring.Service;

import dc.unifacef.sonoInteligenteSpring.Model.SmartLive;
import dc.unifacef.sonoInteligenteSpring.Repository.SmartLiveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartLiveService {
    private final SmartLiveRepository repo;

    public SmartLiveService(SmartLiveRepository repo) {
        this.repo = repo;
    }

    public List<SmartLive> list() {
        return repo.findAll();
    }

    public Optional<SmartLive> findById(Long id) {
        return repo.findById(id);
    }

    public SmartLive create(SmartLive smartLive){
        return repo.save(smartLive);
    }

    public SmartLive patch(Long id, SmartLive smartLive) {
        if(repo.existsById(id)){
            smartLive.setId(id);
            return repo.save(smartLive);
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
