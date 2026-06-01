package dc.unifacef.sonoInteligenteSpring.Service;

import dc.unifacef.sonoInteligenteSpring.Model.Administrador;
import dc.unifacef.sonoInteligenteSpring.Model.Paciente;
import dc.unifacef.sonoInteligenteSpring.Repository.AdministradorRespository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService {

    private final AdministradorRespository repo;
    public AdministradorService(AdministradorRespository repo){
        this.repo = repo;
    }


    // login logic
    public String efetuarLogin(String email, String senha) {

        Optional<Administrador> adminOptional = repo.findByEmail(email);
        Administrador admin;

        if (adminOptional.isPresent()) {
            admin = adminOptional.get();
        } else {
            throw new RuntimeException("E-mail não cadastrado!");
        }

        if (admin.getSenha().equals(senha)) {
            admin.login(email, senha);
            return "Login efetuado com sucesso -> " + admin.getNome();
        } else {
            throw new RuntimeException("Senha incorreta");
        }
    }

        // patch and create
        public Administrador patch(Long id, Administrador admin){
            if(repo.existsById(id)){
                admin.setId(id);
                return repo.save(admin);
            }
            return null;
        }

        public Administrador create(Administrador adm){
            return repo.save(adm);
        }



}
