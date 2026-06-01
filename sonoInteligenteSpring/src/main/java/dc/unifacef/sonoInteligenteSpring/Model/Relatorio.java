package dc.unifacef.sonoInteligenteSpring.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="relatorios")
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false)
    private LocalDateTime dataEmissao;

    @Column(nullable = false)
    private String relatorio;

    @Column(nullable = false)
    private Long IDPaciente;

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public void setIDPaciente(Long IDPaciente) {
        this.IDPaciente = IDPaciente;
    }

    public Long getID() {
        return this.ID;
    }

    public LocalDateTime getDataEmissao() {
        return this.dataEmissao;
    }

    public String getRelatorio() {
        return this.relatorio;
    }

    public Long getIDPaciente() {
        return this.IDPaciente;
    }
}