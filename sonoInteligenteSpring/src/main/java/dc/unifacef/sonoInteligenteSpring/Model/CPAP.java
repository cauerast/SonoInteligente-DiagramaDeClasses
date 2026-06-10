package dc.unifacef.sonoInteligenteSpring.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cpaps")
public class CPAP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String tipoConexao;
    private boolean status;
    private LocalDateTime dataInicio;
    private LocalDateTime ultimaAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonIgnore
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    public CPAP() {}

    public CPAP(Long id, String modelo, String tipoConexao, boolean status, LocalDateTime dataInicio, Fabricante fabricante) {
        this.id = id;
        this.modelo = modelo;
        this.tipoConexao = tipoConexao;
        this.status = status;
        this.dataInicio = dataInicio;
        this.ultimaAtualizacao = LocalDateTime.now();
        this.fabricante = fabricante;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Long getId() {
        return this.id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getTipoConexao() {
        return this.tipoConexao;
    }

    public boolean isStatus() {
        return this.status;
    }

    public LocalDateTime getDataInicio() {
        return this.dataInicio;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return this.ultimaAtualizacao;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public Fabricante getFabricante() {
        return this.fabricante;
    }
}