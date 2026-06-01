package dc.unifacef.sonoInteligenteSpring.Service;

import dc.unifacef.sonoInteligenteSpring.Model.Paciente;
import dc.unifacef.sonoInteligenteSpring.Repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository repo;
    public PacienteService(PacienteRepository repo){
        this.repo = repo;
    }

    public List<Paciente> list(){
        return repo.findAll();
    }

    public Optional<Paciente> findById(Long id){
        return repo.findById(id);
    }

    public Boolean remove(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Paciente patch(Long id, Paciente paciente){
        if(repo.existsById(id)){
            paciente.setId(id);
            return repo.save(paciente);
        }
        return null;
    }

    public Paciente create(Paciente paciente){
        return repo.save(paciente);
    }

}


