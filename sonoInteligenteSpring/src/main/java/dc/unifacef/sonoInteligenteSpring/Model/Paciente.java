package dc.unifacef.sonoInteligenteSpring.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    private String cidade;
    private String telefone;
    private LocalDate dataNasc;

    @Transient
    private CPAP cpap;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Relatorio> relatorios;

    public Paciente() {}

    public Paciente(Long id, String nome, String cpf, String cidade, String telefone, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public void setCpap(Long id, String modelo, String tipoConexao, boolean status, LocalDateTime dataInicio, Fabricante fabricante){
        this.cpap = new CPAP(id, modelo, tipoConexao, status, dataInicio, fabricante);
    }

    public void setRelatorios(List<Relatorio> relatorios){
        this.relatorios = relatorios;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
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

    public List<Relatorio> getRelatorios(){
        return relatorios;
    }

    @Override
    public String toString() {
        return "{" +
                "\nId: " + this.id +
                "\nNome: " + this.nome +
                "\nCpf:" + this.cpf +
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
