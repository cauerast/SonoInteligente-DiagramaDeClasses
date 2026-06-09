package dc.unifacef.sonoInteligenteSpring.Service;

import dc.unifacef.sonoInteligenteSpring.Model.CPAP;
import dc.unifacef.sonoInteligenteSpring.Repository.CPAPRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CPAPService {

    private final CPAPRepository repo;

    public CPAPService(CPAPRepository repo) {
        this.repo = repo;
    }

    public List<CPAP> list() {
        return repo.findAll();
    }

    public Optional<CPAP> findById(Long id) {
        return repo.findById(id);
    }

    public List<CPAP> findByPacienteId(Long pacienteId) {
        return repo.findByPacienteId(pacienteId);
    }

    public CPAP create(CPAP cpap) {
        return repo.save(cpap);
    }

    public CPAP patch(Long id, CPAP cpap) {
        if (repo.existsById(id)) {
            cpap.setId(id);
            return repo.save(cpap);
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