package dc.unifacef.sonoInteligenteSpring.Repository;

import dc.unifacef.sonoInteligenteSpring.Model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRespository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByEmail(String email);
}

