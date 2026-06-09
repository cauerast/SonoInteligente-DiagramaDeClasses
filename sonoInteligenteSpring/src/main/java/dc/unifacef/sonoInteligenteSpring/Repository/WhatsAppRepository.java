package dc.unifacef.sonoInteligenteSpring.Repository;

import dc.unifacef.sonoInteligenteSpring.Model.WhatsApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhatsAppRepository extends JpaRepository<WhatsApp, Long> {
    List<WhatsApp> findByRelatorioId(Long relatorioId);
}