package dc.unifacef.sonoInteligenteSpring.Service;

import dc.unifacef.sonoInteligenteSpring.Model.AirView;
import dc.unifacef.sonoInteligenteSpring.Repository.AirViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirViewService {
    private final AirViewRepository repo;

    public AirViewService(AirViewRepository repo) {
        this.repo = repo;
    }

    public List<AirView> list() {
        return repo.findAll();
    }

    public Optional<AirView> findById(Long id) {
        return repo.findById(id);
    }

    public AirView create(AirView airView){
        return repo.save(airView);
    }

    public AirView patch(Long id, AirView airView) {
        if(repo.existsById(id)){
            airView.setId(id);
            return repo.save(airView);
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
