import java.time.LocalDateTime;

public class Relatorio {
    private int ID;
    private LocalDateTime dataEmissao;
    private String relatorio;
    private Paciente paciente;

    public Relatorio() {}

    public Relatorio(int ID, LocalDateTime dataEmissao, Paciente paciente) {
        this.ID = ID;
        this.dataEmissao = dataEmissao;
        this.paciente = paciente;
        this.relatorio = gerarRelatorio();
    }

    public void setID(int ID) {
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

    public int getID() {
        return ID;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String gerarRelatorio(){
        System.out.println("Gerando relatório...");
        return paciente.toString();
    }

    @Override
    public String toString() {
        return "\n\tRelatorio{" +
                "\nID: " + this.ID +
                "\nData de Emissão: " + this.dataEmissao +
                "\nRelatório: " + this.relatorio +
                "\nPaciente=" + this.paciente +
                "\n}";
    }
}
