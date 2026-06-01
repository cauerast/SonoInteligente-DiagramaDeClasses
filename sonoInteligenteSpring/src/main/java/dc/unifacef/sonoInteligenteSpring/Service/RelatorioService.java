package dc.unifacef.sonoInteligenteSpring.Service;

import dc.unifacef.sonoInteligenteSpring.Model.Relatorio;
import dc.unifacef.sonoInteligenteSpring.Repository.RelatorioRepository;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {
    private RelatorioRepository repo;

    public RelatorioService(RelatorioRepository repo) {
        this.repo = repo;
    }

    public Relatorio gerarRelatorio(Relatorio relatorio){
        return repo.save(relatorio);
    }
}
