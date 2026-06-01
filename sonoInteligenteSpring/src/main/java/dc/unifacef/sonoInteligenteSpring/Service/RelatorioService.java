package dc.unifacef.sonoInteligenteSpring.Service;

import dc.unifacef.sonoInteligenteSpring.Model.Paciente;
import dc.unifacef.sonoInteligenteSpring.Model.Relatorio;
import dc.unifacef.sonoInteligenteSpring.Repository.RelatorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelatorioService {
    private final RelatorioRepository repo;

    public RelatorioService(RelatorioRepository repo) {
        this.repo = repo;
    }

    public List<Relatorio> list() {
        return repo.findAll();
    }

    public Optional<Relatorio> findById(Long id) {
        return repo.findById(id);
    }

    public Relatorio create(Relatorio relatorio){
        return repo.save(relatorio);
    }

    public Relatorio patch(Long id, Relatorio relatorio) {
        if(repo.existsById(id)){
            relatorio.setId(id);
            return repo.save(relatorio);
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
