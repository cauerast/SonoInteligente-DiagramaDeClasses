import java.time.LocalDateTime;

public class CPAP {
    private int ID;
    private String modelo, tipoConexao;
    private boolean status;
    private LocalDateTime dataInicio;
    private LocalDateTime ultimaAtualizacao;
    private Fabricante fabricante;

    public CPAP() {}

    public CPAP(int ID, String modelo, String tipoConexao, boolean status, LocalDateTime dataInicio, Fabricante fabricante) {
        this.ID = ID;
        this.modelo = modelo;
        this.tipoConexao = tipoConexao;
        this.status = status;
        this.dataInicio = dataInicio;
        this.ultimaAtualizacao = LocalDateTime.now();
        this.fabricante = fabricante;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getID() {
        return this.ID;
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

    @Override
    public String toString() {
        return "\n\tCPAP{" +
                "\nID: " + this.ID +
                "\nModelo: " + this.modelo +
                "\nTipo de Conexão: " + this.tipoConexao +
                "\nStatus: " + this.status +
                "\nData de Início: " + this.dataInicio +
                "\nÚltima atualização: " + this.ultimaAtualizacao +
                "\nFabricante: " + this.fabricante +
                "\n}";
    }

    public void atualizarDados(){
        System.out.println("Atualizando os dados do paciente...");
    }
}
