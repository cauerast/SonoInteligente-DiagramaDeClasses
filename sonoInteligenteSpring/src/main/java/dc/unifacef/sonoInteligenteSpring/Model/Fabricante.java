package dc.unifacef.sonoInteligenteSpring.Model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Fabricante{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected boolean statusConexao;

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatusConexao(boolean statusConexao) {
        this.statusConexao = statusConexao;
    }

    public Long getId() {
        return this.id;
    }

    public boolean isStatusConexao() {
        return this.statusConexao;
    }
}