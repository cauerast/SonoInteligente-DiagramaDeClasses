package dc.unifacef.sonoInteligenteSpring.Model;

import java.time.LocalDateTime;

public class CPAP {
    private Long id;
    private String modelo, tipoConexao;
    private boolean status;
    private LocalDateTime dataInicio;
    private LocalDateTime ultimaAtualizacao;
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

    public void setFabricante(Fabricante fabricante){
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

    public Fabricante getFabricante(){
        return this.fabricante;
    }

    public void atualizarDados(){
        System.out.println("Atualizando os dados do paciente...");
    }
}
