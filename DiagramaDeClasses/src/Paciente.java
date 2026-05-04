import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente {
    private int ID;
    private String nome, CPF, cidade, telefone;
    private LocalDate dataNasc;
    private CPAP cpap;

    public Paciente() {}

    public Paciente(int ID, String nome, String CPF, String cidade, String telefone, LocalDate dataNasc) {
        this.ID = ID;
        this.nome = nome;
        this.CPF = CPF;
        this.cidade = cidade;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setCpap(int ID, String modelo, String tipoConexao, boolean status, LocalDateTime dataInicio, Fabricante fabricante){
        this.cpap = new CPAP(ID, modelo, tipoConexao, status, dataInicio, fabricante);
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public CPAP getCpap(){
        return this.cpap;
    }

    @Override
    public String toString() {
        return "{" +
                "\nID: " + this.ID +
                "\nNome: " + this.nome +
                "\nCPF:" + this.CPF +
                "\nCidade: " + this.cidade +
                "\nTelefone: " + this.telefone +
                "\nData de Nascimento: " + this.dataNasc +
                "\nCPAP: " + this.cpap +
                "\n}";
    }

    public void classificarIndiceApneia(){
        System.out.println("Classificando paciente pelo índice de apneia do sono...");
    }

    public void exibirDadosPaciente(){
        System.out.println("Exibindo dados de uso do paciente...");
    }
}
