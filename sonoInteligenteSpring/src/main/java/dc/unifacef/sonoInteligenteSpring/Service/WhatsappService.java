package dc.unifacef.sonoInteligenteSpring.Service;
import dc.unifacef.sonoInteligenteSpring.Model.WhatsApp;
import dc.unifacef.sonoInteligenteSpring.Repository.WhatsappRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WhatsappService {
    private WhatsappRepository repo;

    public WhatsappService(WhatsappRepository repo){
        this.repo = repo;
    }
    public List<WhatsApp> listar(){

        return repo.findAll();
    }

    public Optional<WhatsApp> buscarPorId(Long id){

        return repo.findById(id);
    }

    public boolean remove(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public WhatsApp atualiza(Long id, Produto alterado){
        if (repo.existsById(id)){
            alterado.setId(id);
            return repo.save(alterado);
        }
        return null;
    }

    public WhatsApp salva(WhatsApp whatsApp){
        if (produto.getDescrico().equals("robo")){
            return null;
        }
        return repo.save(whatsApp);
    }
}

