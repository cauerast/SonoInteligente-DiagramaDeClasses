package dc.unifacef.sonoInteligenteSpring.Repository;

import dc.unifacef.sonoInteligenteSpring.Model.CPAP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CPAPRepository extends JpaRepository<CPAP, Long> {
    List<CPAP> findByPacienteId(Long pacienteId);
}