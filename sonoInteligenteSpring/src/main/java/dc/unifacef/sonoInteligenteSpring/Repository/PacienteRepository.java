package dc.unifacef.sonoInteligenteSpring.Repository;

import dc.unifacef.sonoInteligenteSpring.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
