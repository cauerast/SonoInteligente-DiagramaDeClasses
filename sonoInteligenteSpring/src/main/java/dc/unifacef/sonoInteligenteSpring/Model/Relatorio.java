package dc.unifacef.sonoInteligenteSpring.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="relatorios")
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataEmissao;

    @Column(nullable = false)
    private String relatorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPaciente", nullable = false)
    @JsonIgnore
    private Paciente paciente;

    public void setId(Long ID) {
        this.id = id;
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
        return this.id;
    }

    public LocalDateTime getDataEmissao() {
        return this.dataEmissao;
    }

    public String getRelatorio() {
        return this.relatorio;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }
}