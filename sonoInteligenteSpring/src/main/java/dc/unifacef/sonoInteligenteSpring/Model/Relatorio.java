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
    private Paciente paciente;

    public void setId(Long ID) {
        this.ID = ID;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Long getId() {
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